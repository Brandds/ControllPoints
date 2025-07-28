package ControllPoints.com.security.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.security.SecurityScheme
import org.springframework.context.annotation.Configuration

@Configuration
@OpenAPIDefinition(
    info = Info(
        title = "Controll Points API",
        version = "1.0",
        description = "Documentação dos endpoints da API do sistema de ponto."
    ),
    security = [SecurityRequirement(name = "bearerAuth")]
)
@SecurityScheme(
    name = "bearerAuth", // Um nome de referência para este esquema
    type = SecuritySchemeType.HTTP, // O tipo de esquema é HTTP
    scheme = "bearer", // O protocolo específico é o "Bearer Token"
    bearerFormat = "JWT" // Um hint para o formato do token
)
class OpenApiConfig{}