package ControllPoints.com.Security.Jwt



import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class CustomAccessDeniedHandler : AccessDeniedHandler {
    override fun handle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        accessDeniedException: AccessDeniedException
    ) {
        val errorResponse = mapOf(
            "timestamp" to LocalDateTime.now().toString(),
            "status" to HttpServletResponse.SC_FORBIDDEN,
            "error" to "Forbidden",
            "message" to "Você não tem permissão para acessar este recurso.",
            "path" to request.requestURI
        )

        response.status = HttpServletResponse.SC_FORBIDDEN
        response.contentType = MediaType.APPLICATION_JSON_VALUE

        val objectMapper = ObjectMapper()
        response.writer.write(objectMapper.writeValueAsString(errorResponse))
    }
}
