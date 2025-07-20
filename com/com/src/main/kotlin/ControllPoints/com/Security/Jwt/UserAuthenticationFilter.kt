package ControllPoints.com.Security.Jwt

import ControllPoints.com.Security.config.SecurityConfig
import ControllPoints.com.Security.service.UserDetailsImpl
import ControllPoints.com.repository.ColaboradorRepository
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.util.AntPathMatcher
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException

@Component
class UserAuthenticationFilter(
    private val jwtTokenService: JwtTokenService,
    private val colaboradorRepository: ColaboradorRepository
) : OncePerRequestFilter() {
    private val pathMatcher = AntPathMatcher()
    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            if (checkIfEndpointIsNotPublic(request)) {
                val token = recoveryToken(request)

                if (!token.isNullOrBlank()) {
                    try {
                        val subject = jwtTokenService.getSubjectFromToken(token)
                        val user = colaboradorRepository.findByEmail(subject)
                            .orElseThrow { RuntimeException("Usuário não encontrado a partir do token.") }

                        val userDetails = UserDetailsImpl(user)

                        val authentication = UsernamePasswordAuthenticationToken(
                            userDetails.username,
                            null,
                            userDetails.authorities
                        )

                        SecurityContextHolder.getContext().authentication = authentication

                    } catch (ex: Exception) {
                        logger.warn("Falha na validação do token JWT: ${ex.message}")
                        // Não lança exceção aqui
                    }
                } else {
                    logger.debug("Token ausente no header Authorization")
                    // Não autentica, não lança exceção
                }
            }

            filterChain.doFilter(request, response)

        } catch (ex: Exception) {
            // Só captura exceções inesperadas — idealmente não deve chegar aqui por erros de token
            logger.error("Erro inesperado no filtro JWT: ", ex)
            response.status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR
            response.contentType = "application/json"
            response.writer.write(
                """
            {
                "status": 500,
                "error": "Internal Server Error",
                "message": "${ex.message}"
            }
            """.trimIndent()
            )
        }
    }




    private fun recoveryToken(request: HttpServletRequest): String? {
        val authorizationHeader = request.getHeader("Authorization")
        // 2. Uso do operador 'removePrefix' com safe call '?'
        return authorizationHeader?.removePrefix("Bearer ")
    }

    private fun checkIfEndpointIsNotPublic(request: HttpServletRequest): Boolean {
        return SecurityConfig.ENDPOINTS_PUBLICOS.none { path ->
            pathMatcher.match(path, request.requestURI)
        }
    }
}