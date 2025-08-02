import ControllPoints.com.base.BaseEntity
import ControllPoints.com.enums.TipoRegistroPonto
import ControllPoints.com.model.CargoColaborador
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
class RegistroPonto(
    id : Long? = null,

    @Column(nullable = false)
    val timestamp: LocalDateTime,

    @Column(nullable = false)
    val tipoRegistroPontoCodigo: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargo_colaborador_id", nullable = false)
    var cargoColaborador: CargoColaborador,

    @Column
    var localizacao: String? = null,

    @Column
    var observacao: String? = null

) : BaseEntity(id) {

    val tipoRegistroPonto: TipoRegistroPonto?
        get() = TipoRegistroPonto.entries.find { it.codigo == tipoRegistroPontoCodigo }
}
