package ControllPoints.com.dto

import ControllPoints.com.base.BaseEntity

class EnderecoDTO (
    id : Long?,
    val logradouro : String,
    val complemento : String?,
    val bairro : String,
    val municipio : String,
    val uf : String,
    val cep : String

) : BaseEntity(id){
}