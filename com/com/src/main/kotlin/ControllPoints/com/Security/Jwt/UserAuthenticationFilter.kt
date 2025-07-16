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
        if (checkIfEndpointIsNotPublic(request)) {
            // Tenta recuperar o token a partir do cabeçalho
            val token = recoveryToken(request)

            // Se o token existir, processa a autenticação
            token?.let {
                val subject = jwtTokenService.getSubjectFromToken(it)
                val user = colaboradorRepository.findByEmail(subject)
                    .orElseThrow { RuntimeException("Usuário não encontrado a partir do token.") }

                val userDetails = UserDetailsImpl(user)

                val authentication = UsernamePasswordAuthenticationToken(
                    userDetails.username,
                    null,
                    userDetails.authorities
                )

                // 3. Define a autenticação no contexto de segurança (usando property access)
                SecurityContextHolder.getContext().authentication = authentication
            } ?: throw RuntimeException("O token está ausente ou mal formatado.")
        }

        filterChain.doFilter(request, response)
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