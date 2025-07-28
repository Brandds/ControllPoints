package ControllPoints.com.security.service

import ControllPoints.com.model.Colaborador
import ControllPoints.com.model.Empresa
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImpl private constructor(
    private val user: Any,
    private val authorities : Collection<GrantedAuthority>
) : UserDetails {

    constructor(colaborador: Colaborador) : this(
        colaborador,
        colaborador.listaRole.map { SimpleGrantedAuthority("ROLE_" + it.name.name) }
    )

    constructor(empresa: Empresa) : this(
        empresa,
        empresa.listaRole.map { SimpleGrantedAuthority("ROLE_" + it.name.name) }
    )

    override fun getAuthorities(): Collection<GrantedAuthority> = this.authorities

    override fun getPassword(): String {
        return when (user) {
            is Colaborador -> user.senha
            is Empresa -> user.senha
            else -> ""
        }
    }

    override fun getUsername(): String {
        return when (user) {
            is Colaborador -> user.email
            is Empresa -> user.email
            else -> ""
        }
    }

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}
