package ControllPoints.com.Security.config


import ControllPoints.com.Security.Jwt.CustomAccessDeniedHandler
import ControllPoints.com.Security.Jwt.UserAuthenticationFilter
import ControllPoints.com.Security.exception.CustomAuthenticationEntryPoint
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
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
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.security.SecurityScheme
import org.springframework.http.HttpMethod


@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val userAuthenticationFilter: UserAuthenticationFilter,
    private val customAuthenticationEntryPoint: CustomAuthenticationEntryPoint,
    private val customAccessDeniedHandler: CustomAccessDeniedHandler,
    @Value("\${meu-app.links.localhost}") private val linkLocalhost: String

) {

    // 2. Definimos as constantes com os endpoints
    companion object {
         val ENDPOINTS_PUBLICOS = arrayOf(
             "/auth/login",
             "/colaboradores",
             "/colaboradores/cadastrarColaborador",
             "/empresa/cadastrar",
             // Endpoints do Swagger/OpenAPI
             "/swagger-ui.html",
             "/swagger-ui/**",
             "/v3/api-docs/**",
             "/swagger-resources/**",
             // Endpoint do H2
             "/h2-console/**"
         )
         val ENDPOINTS_ADMIN = arrayOf(
            "/users/test/administrator"
        )
         val ENDPOINTS_CLIENTE = arrayOf(
            "/users/test/customer"
        )
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .cors { }
            .headers { headers ->
                headers.frameOptions { it.sameOrigin() }
            }
            .csrf { it.disable() }
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                    .requestMatchers(PathRequest.toH2Console()).permitAll()
                    .requestMatchers(*ENDPOINTS_PUBLICOS).permitAll()
                    .requestMatchers(*ENDPOINTS_ADMIN).hasRole("ADMINISTRATOR")
                    .requestMatchers(*ENDPOINTS_CLIENTE).hasRole("CUSTOMER")
                    .anyRequest().authenticated()
            }
            .exceptionHandling {
                it.authenticationEntryPoint(customAuthenticationEntryPoint)
                it.accessDeniedHandler(customAccessDeniedHandler)

            }
            .addFilterBefore(userAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }

    // 6. Expõe o bean do AuthenticationManager
    @Bean
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
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