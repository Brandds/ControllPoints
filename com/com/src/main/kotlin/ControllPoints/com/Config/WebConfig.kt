package ControllPoints.com.Config


import org.springframework.beans.factory.annotation.Value
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
            .cors { } // Habilita CORS usando o bean 'corsConfigurationSource'
            .csrf { it.disable() }
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/**").permitAll() // Sintaxe correta e padrão
                    .anyRequest().authenticated()
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