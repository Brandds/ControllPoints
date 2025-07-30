package ControllPoints.com.model

import ControllPoints.com.base.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import java.math.BigDecimal

@Entity
class Cargo(
    id: Long? = null,
    var nome :String,
    var descricao: String? = null,
    var nivel: Int? = null,
    var salarioBase: BigDecimal? = null,
    var ativo: Boolean = true,

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    var empresa: Empresa,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cargo_roles",
        joinColumns =  [JoinColumn(name = "cargo_id")],
        inverseJoinColumns = [JoinColumn(name= "role_id")])
    val listaRole : Set<Role> = mutableSetOf()
): BaseEntity(id) {
}