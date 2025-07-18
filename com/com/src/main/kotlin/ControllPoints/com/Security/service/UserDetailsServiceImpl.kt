package ControllPoints.com.Security.service

import ControllPoints.com.repository.ColaboradorRepository
import ControllPoints.com.repository.EmpresaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(

    val colaboradorRepository: ColaboradorRepository,
    val empresaRepository: EmpresaRepository
) : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(email: String): UserDetails {
        val colaboradorOptional = colaboradorRepository.findByEmail(email);
        if(colaboradorOptional.isPresent){
            return UserDetailsImpl(colaboradorOptional.get());
        }
        val empresaOptional = empresaRepository.findByEmail(email);
        if(empresaOptional.isPresent){
            return UserDetailsImpl(empresaOptional.get());
        }
        throw UsernameNotFoundException("Usuário com e-mail '$email' não encontrado.")
    }
}