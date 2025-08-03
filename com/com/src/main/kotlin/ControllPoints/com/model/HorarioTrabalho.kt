package ControllPoints.com.model

import ControllPoints.com.base.BaseEntity
import jakarta.persistence.*
import java.time.LocalTime

@Entity
class HorarioTrabalho(
    id: Long? = null,

    @Column(nullable = false)
    var descricao: String,

    @Column(nullable = false)
    var horarioEntrada: LocalTime,

    @Column(nullable = false)
    var horarioInicioPausa: LocalTime,

    @Column(nullable = false)
    var horarioFimPausa: LocalTime,

    @Column(nullable = false)
    var horarioSaida: LocalTime,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    var empresa: Empresa,

    @OneToMany(mappedBy = "horarioTrabalho", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var listaColaboradoresCargo: List<CargoColaborador> = listOf()


) : BaseEntity(id) {}