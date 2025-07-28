package ControllPoints.com.model

import ControllPoints.com.base.BaseEntity
import ControllPoints.com.model.Endereco
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinColumns
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import java.time.LocalDate

@Entity
class Empresa (
    id : Long? = null,
    val cnpj: String,
    val razaoSocial : String,
    val nomeFantasia : String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "endereco_id")
    val endereco : Endereco? = null,
    val telefone : String,
    val dataCadastro : LocalDate?,

    @OneToMany(mappedBy = "empresa", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val listaColaborador: List<Colaborador> = listOf<Colaborador>(),

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "empresa_roles",
        joinColumns = [JoinColumn(name = "empresa_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")])
    val listaRole: Set<Role> = mutableSetOf(),
    val senha : String,
    val email : String

//    @OneToMany(mappedBy = "empresa", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
//    val listaCargo : List<Cargo> = listOf<Cargo>()
): BaseEntity(id) {
}