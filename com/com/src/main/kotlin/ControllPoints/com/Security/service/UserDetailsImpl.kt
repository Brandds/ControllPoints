package ControllPoints.com.Security.service

import ControllPoints.com.model.Usuario
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImpl(private val user: Usuario) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> {
        // A função map do Kotlin é mais concisa que streams para casos simples
        return user.listaRole.map { role ->
            SimpleGrantedAuthority(role.name.name)
        }
    }

    override fun getPassword(): String = user.senha

    override fun getUsername(): String = user.email

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}
