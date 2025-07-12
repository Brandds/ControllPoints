package ControllPoints.com.model

import ControllPoints.com.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.ManyToOne
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class Usuario (

    val nome: String,

    var senha: String,

    @Column(unique=true)
    var email: String,

    @Column(unique=true)
    val login: String,

    @ManyToOne(optional = false)
    var empresa: Empresa,

    var ativo: Boolean,

    @Column(unique=true)
    val cpf: String,

    var telefone: String?

) : BaseEntity() {

}