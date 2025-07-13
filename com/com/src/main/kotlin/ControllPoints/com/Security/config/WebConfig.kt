package ControllPoints.com.Security.config


import ControllPoints.com.Security.Jwt.UserAuthenticationFilter
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val userAuthenticationFilter: UserAuthenticationFilter,
    @Value("\${meu-app.links.localhost}") private val linkLocalhost: String

) {

    // 2. Definimos as constantes com os endpoints
    companion object {
        private val ENDPOINTS_PUBLICOS = arrayOf(
            "/auth/login", // Ajustei para o seu provável endpoint de login
            "/colaboradores"
        )
        private val ENDPOINTS_ADMIN = arrayOf(
            "/users/test/administrator"
        )
        private val ENDPOINTS_CLIENTE = arrayOf(
            "/users/test/customer"
        )
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            // 3. Desabilita CSRF e configura a sessão para STATELESS (essencial para JWT)
            .csrf { it.disable() }
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            // 4. Configura a autorização das requisições HTTP
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers(*ENDPOINTS_PUBLICOS).permitAll()
                    .requestMatchers(*ENDPOINTS_ADMIN).hasRole("ADMINISTRATOR")
                    .requestMatchers(*ENDPOINTS_CLIENTE).hasRole("CUSTOMER")
                    // .requestMatchers("/users/test").authenticated() // Se você tiver endpoints que só precisam de autenticação simples
                    .anyRequest().authenticated() // Mudei de denyAll para authenticated, que é mais comum. Se quiser negar, use .denyAll()
            }
            // 5. Adiciona seu filtro de JWT antes do filtro padrão do Spring
            .addFilterBefore(userAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }

    // 6. Expõe o bean do AuthenticationManager
    @Bean
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
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