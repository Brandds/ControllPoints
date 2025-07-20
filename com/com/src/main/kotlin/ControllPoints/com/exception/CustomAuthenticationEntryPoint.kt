package ControllPoints.com.Security.exception

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class CustomAuthenticationEntryPoint : AuthenticationEntryPoint {

    private val logger = LoggerFactory.getLogger(CustomAuthenticationEntryPoint::class.java)

    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException
    ) {
        logger.error("🔒 CustomAuthenticationEntryPoint chamado: {}", authException.message)

        response.status = HttpServletResponse.SC_UNAUTHORIZED
        response.contentType = "application/json"
        response.writer.write(
            """{
                "timestamp": "${LocalDateTime.now()}",
                "status": 401,
                "error": "Unauthorized",
                "message": "Token inválido ou não fornecido",
                "path": "${request.requestURI}"
            }""".trimIndent()
        )
    }
}