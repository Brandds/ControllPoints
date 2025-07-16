package ControllPoints.com.Security.service

import ControllPoints.com.repository.ColaboradorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(

    val colaboradorRepository: ColaboradorRepository
) : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(email: String): UserDetails {
        // Busca um Colaborador pelo email (que é o 'username' no login)
        val colaborador = colaboradorRepository.findByEmail(email)
            // Se não encontrar, lança a exceção que o Spring Security espera.
            .orElseThrow { UsernameNotFoundException("Usuário com e-mail '$email' não encontrado.") }

        // Se encontrou, retorna a implementação de UserDetails.
        return UserDetailsImpl(colaborador)
    }
}