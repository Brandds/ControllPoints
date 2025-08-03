package ControllPoints.com.model

import ControllPoints.com.base.BaseEntity
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
class Cargo(
    id: Long? = null,

    @Column
    var nome :String,

    @Column(length = 500)
    var descricao: String? = null,

    @Column
    var nivel: Int? = null,

    @Column
    var salarioBase: BigDecimal? = null,

    @Column
    salarioHoraRef: BigDecimal? = null,

    @Column
    var ativo: Boolean = true,


    @ManyToOne
    @JoinColumn(name = "empresa_id")
    var empresa: Empresa,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cargo_roles",
        joinColumns =  [JoinColumn(name = "cargo_id")],
        inverseJoinColumns = [JoinColumn(name= "role_id")])
    val listaRole : Set<Role> = mutableSetOf()

    @OneToMany(mappedBy = "cargo", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var listaColaboradoresCargo: List<CargoColaborador> = listOf()
): BaseEntity(id) {
}
