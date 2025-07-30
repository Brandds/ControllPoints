package ControllPoints.com.dto

import ControllPoints.com.base.BaseDTO
import ControllPoints.com.enums.SituacaoEmpresa
import ControllPoints.com.model.Role
import java.math.BigDecimal
import java.time.LocalDate

class EmpresaDTO(
    id :Long?,
    val cnpj : String,
    val razaoSocial: String,
    val nomeFantasia :String,
    val telefone : String,
    val dataCadastro : LocalDate?,
    val enderecoDTO: EnderecoDTO? = null,
    val senha : String,
    val email : String,
    val tipo : String,
    val naturezaJuridica : String,
    val abertura : LocalDate,
    val situacaoEmpresa : SituacaoEmpresa,
    val capitalSocial : BigDecimal,
    val listaRole: MutableSet<Role> = mutableSetOf(),
):  BaseDTO(id){
    var listaColaboradorDTO: List<ColaboradorDTO>? = listOf<ColaboradorDTO>()
}