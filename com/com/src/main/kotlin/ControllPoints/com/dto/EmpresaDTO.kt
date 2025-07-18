package ControllPoints.com.dto

import ControllPoints.com.base.BaseDTO
import java.time.LocalDate

class EmpresaDTO(
    id :Long?,
    val cnpj : String,
    val razaoSocial: String,
    val nomeFantasia :String,
    val telefone : String,
    val dataCadastro : LocalDate,
    var listaColaboradorDTO: List<ColaboradorDTO>? = listOf<ColaboradorDTO>(),
    val enderecoDTO: EnderecoDTO? = null,
    val senha : String,
    val email : String
):  BaseDTO(id){
}