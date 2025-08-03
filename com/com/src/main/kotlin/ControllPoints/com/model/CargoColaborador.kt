package ControllPoints.com.model

import ControllPoints.com.base.BaseEntity
import RegistroPonto
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import java.math.BigDecimal
import java.time.LocalDate

@Entity
class CargoColaborador(
    id : Long? = null,

    @Column
    val dataInicio: LocalDate,

    @Column
    val dataFim: LocalDate,

    @Column
    var valorHoraEfetivo: BigDecimal,


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "colaborador_id")
    var colaborador: Colaborador,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargo_id")
    var cargo: Cargo,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "horario_trabalho_id")
    var horarioTrabalho: HorarioTrabalho,

    @OneToMany(mappedBy = "cargoColaborador", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var registrosDePonto: List<RegistroPonto> = listOf()

): BaseEntity(id) {}