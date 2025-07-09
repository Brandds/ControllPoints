package ControllPoints.com.Config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig  : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")// Aplica a configuração a todos os endpoints da API
            .allowedOrigins("*") // Permite requisições de qualquer origem (servidor)
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT")// Métodos HTTP permitidos
            .allowedHeaders("*") // Permite todos os cabeçalhos na requisição
            .allowCredentials(true)// Importante se você usa cookies ou sessões (token)
    }
}