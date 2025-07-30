package ControllPoints.com.model

import ControllPoints.com.base.BaseEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class Usuario (
    id : Long?,
    val nome: String,

    var senha: String,

    @Column(unique=true)
    var email: String,

    @Column(unique=true)
    val login: String?,

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    var empresa: Empresa,

    var ativo: Boolean,

    @Column(unique=true)
    val cpf: String,

    var telefone: String?
) : BaseEntity(id) {

}