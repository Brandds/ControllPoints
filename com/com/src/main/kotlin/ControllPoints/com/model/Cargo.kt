package ControllPoints.com.model

import ControllPoints.com.base.BaseEntity
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
class Cargo(
    id: Long? = null,

    @Column(nullable = false)
    val nome: String,

    @Column
    var descricao: String,

    @Column
    var valorHoraRef: BigDecimal,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    var empresa: Empresa,

    @OneToMany(mappedBy = "cargo", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var listaColaboradoresCargo: List<CargoColaborador> = listOf()

): BaseEntity(id) {}