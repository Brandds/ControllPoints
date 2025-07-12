package ControllPoints.com.Model

import ControllPoints.com.Base.BaseEntity
import ControllPoints.com.Model.Endereco.Endereco
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne

@Entity
data class Empresa(
    val cnpj : String,
    val razaoSocial : String,
    val nomeFantasia : String,

    @OneToOne (cascade =[CascadeType.ALL])
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    val endeco : Endereco

) : BaseEntity() {
}