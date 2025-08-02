package ControllPoints.com.dto

import ControllPoints.com.base.BaseDTO
import ControllPoints.com.model.Empresa
import jakarta.persistence.Column
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.math.BigDecimal

data class CargoDTO(
    val id: Long?,
    val nome: String,
    val descricao: String,
    val valorHoraRef: BigDecimal,
    val empresaId: Long
)