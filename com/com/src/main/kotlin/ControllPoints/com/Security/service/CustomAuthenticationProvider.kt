package ControllPoints.com.Security.service

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class CustomAuthenticationProvider(
    private val userDetailsService: UserDetailsService,
    private val passwordEncoder: PasswordEncoder
) : AuthenticationProvider {

    override fun authenticate(authentication: Authentication): Authentication {
        val email = authentication.name
        val senhaPuraEnviada = authentication.credentials.toString()

        println("----------- INICIANDO AUTENTICAÇÃO CUSTOMIZADA -----------")
        println("1. Buscando usuário com email: '$email'")

        val userDetails = userDetailsService.loadUserByUsername(email)

        val hashDoBanco = userDetails.password
        println("3. Hash salvo no banco: '$hashDoBanco'")
        println("   - Comprimento do hash: ${hashDoBanco.length}")


        if (passwordEncoder.matches(senhaPuraEnviada, hashDoBanco)) {
            println("4. SUCESSO! As senhas correspondem.")
            println("----------------------------------------------------------")

            return UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.authorities
            )
        } else {
            println("4. FALHA! As senhas NÃO correspondem.")
            println("----------------------------------------------------------")
            throw BadCredentialsException("Credenciais inválidas.")
        }
    }

    override fun supports(authentication: Class<*>): Boolean {
        return authentication == UsernamePasswordAuthenticationToken::class.java
    }
}