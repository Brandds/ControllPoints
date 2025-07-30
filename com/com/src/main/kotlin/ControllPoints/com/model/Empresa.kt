package ControllPoints.com.model

import ControllPoints.com.base.BaseEntity
import ControllPoints.com.enums.SituacaoEmpresa
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import java.math.BigDecimal
import kotlin.collections.Set
import java.time.LocalDate

@Entity
class Empresa (
    id : Long? = null,
    var cnpj: String,
    var razaoSocial : String,
    var nomeFantasia : String,
    var tipo : String,
    var naturezaJuridica : String,
    var abertura : LocalDate,
    var situacaoEmpresa : SituacaoEmpresa,
    var capitalSocial : BigDecimal,
    var senha : String,
    var email : String,
    var telefone : String,
    var dataCadastro : LocalDate?,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "endereco_id")
    var endereco : Endereco? = null,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "empresa_roles",
        joinColumns = [JoinColumn(name = "empresa_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    var listaRole: MutableSet<Role> = mutableSetOf()

): BaseEntity(id) {
    constructor() : this(
        id = null,
        cnpj = "",
        razaoSocial = "",
        nomeFantasia = "",
        tipo = "",
        naturezaJuridica = "",
        abertura = LocalDate.now(),
        situacaoEmpresa = SituacaoEmpresa.ATIVA,
        capitalSocial = BigDecimal.ZERO,
        senha = "",
        email = "",
        telefone = "",
        dataCadastro = LocalDate.now(),
        endereco = null,
        listaRole = mutableSetOf()
    )



    @OneToMany(mappedBy = "empresa", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var listaColaborador: MutableList<Colaborador> = mutableListOf()

    @OneToMany(mappedBy = "empresa", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var listaCargo: MutableList<Cargo> = mutableListOf()

}