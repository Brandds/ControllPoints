package ControllPoints.com.Config


import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class WebConfig(
    @Value("\${meu-app.links.localhost}") private val linkLocalhost: String
)  {


    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            // 1. Autorização de Requisições
            .authorizeHttpRequests { auth ->
                auth
                    // Libera o acesso ao console do H2
                    .requestMatchers(PathRequest.toH2Console()).permitAll()
                    // Exige autenticação para todas as outras requisições
                    .anyRequest().authenticated()
            }
            // 2. Desabilitar CSRF apenas para o H2 Console (mais seguro que desabilitar globalmente)
            .csrf { csrf ->
                csrf.ignoringRequestMatchers(PathRequest.toH2Console())
            }
            // 3. Permitir que o H2 Console seja renderizado em um frame
            .headers { headers ->
                headers.frameOptions { it.sameOrigin() }
            }

        return http.build()
    }
    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {

        val configuration = CorsConfiguration()
        configuration.allowedOrigins = listOf(
            linkLocalhost,  // Para `ionic serve` ou outros servidores web locais
            "http://localhost",       // Para o Android Emulator/WebView
            "capacitor://localhost"   // Para builds nativas com Capacitor
        ) // Origens permitidas

        configuration.allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "OPTIONS")
        configuration.allowedHeaders = listOf("*")
        configuration.allowCredentials = true

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration) // Aplica a configuração a todos os paths

        return source
    }

}