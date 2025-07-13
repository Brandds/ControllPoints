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
    override fun loadUserByUsername(username: String): UserDetails {
        val colaborador = colaboradorRepository.findByCpf(username)
            .orElseThrow { UsernameNotFoundException("Usuário com email $username não encontrado.") }

        return UserDetailsImpl(colaborador)
    }
}