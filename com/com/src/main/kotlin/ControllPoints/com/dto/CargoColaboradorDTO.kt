package ControllPoints.com.dto

import ControllPoints.com.base.BaseDTO
import ControllPoints.com.model.Cargo
import ControllPoints.com.model.Colaborador
import ControllPoints.com.model.HorarioTrabalho
import jakarta.persistence.Column
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.math.BigDecimal
import java.time.LocalDate

class CargoColaboradorDTO(
    id : Long? = null,

    val dataInicio: LocalDate,

    val dataFim: LocalDate,

    var valorHoraEfetivo: BigDecimal,

    var colaborador: Colaborador,

    var cargo: Cargo,

    var horarioTrabalho: HorarioTrabalho,

    ): BaseDTO(id) {
}