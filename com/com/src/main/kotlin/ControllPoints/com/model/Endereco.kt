package ControllPoints.com.model

import ControllPoints.com.base.BaseEntity
import jakarta.persistence.Entity

@Entity
class Endereco (
    id : Long?,
    var logradouro : String,
    var complemento : String?,
    var bairro : String,
    var municipio : String,
    var uf : String,
    var cep : String
) : BaseEntity(id){}