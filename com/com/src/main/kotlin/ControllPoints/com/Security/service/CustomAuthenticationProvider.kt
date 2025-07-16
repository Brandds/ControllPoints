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
        // 1. Pega o email e a senha que o usuário enviou
        val email = authentication.name
        val senhaPuraEnviada = authentication.credentials.toString()

        println("----------- INICIANDO AUTENTICAÇÃO CUSTOMIZADA -----------")
        println("1. Buscando usuário com email: '$email'")

        // 2. Busca o usuário no banco usando o seu UserDetailsService
        val userDetails = userDetailsService.loadUserByUsername(email)

        val hashDoBanco = userDetails.password
        println("2. Usuário encontrado. Senha pura recebida: '$senhaPuraEnviada'")
        println("3. Hash salvo no banco: '$hashDoBanco'")
        println("   - Comprimento do hash: ${hashDoBanco.length}")


        // 4. Compara a senha pura enviada com o hash do banco
        if (passwordEncoder.matches(senhaPuraEnviada, hashDoBanco)) {
            println("4. SUCESSO! As senhas correspondem.")
            println("----------------------------------------------------------")

            // Se as senhas baterem, cria um token de autenticação de sucesso
            return UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.authorities
            )
        } else {
            println("4. FALHA! As senhas NÃO correspondem.")
            println("----------------------------------------------------------")
            // Se não baterem, lança a exceção
            throw BadCredentialsException("Credenciais inválidas.")
        }
    }

    override fun supports(authentication: Class<*>): Boolean {
        // Informa ao Spring que este provedor suporta o tipo de autenticação de usuário e senha
        return authentication == UsernamePasswordAuthenticationToken::class.java
    }
}