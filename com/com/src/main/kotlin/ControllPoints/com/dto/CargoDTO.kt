package ControllPoints.com.dto

import ControllPoints.com.base.BaseDTO
import ControllPoints.com.model.Role
import java.math.BigDecimal

data class CargoDTO(
    id: Long? = null,
    val nome: String,
    val descricao: String?,
    val nivel: Int? = null,
    val salarioBase: BigDecimal? = null,
    val ativo: Boolean = true,
    val valorHoraRef: BigDecimal,
    val empresa: EmpresaDTO,
    val listaRole: Set<Role> = mutableSetOf()

) : BaseDTO(id) {
}
