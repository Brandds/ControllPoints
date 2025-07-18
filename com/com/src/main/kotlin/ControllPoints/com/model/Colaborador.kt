package ControllPoints.com.model

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
class Colaborador(
    id: Long? = null,
    nome: String,
    senha: String,
    email: String,
    login: String? = null,
    empresa: Empresa,
    ativo: Boolean,
    cpf: String,
    telefone: String?,

    @ManyToOne(optional = false)
    var cargo: Cargo,

    var valorHora: Double,

    var salarioBruto: Double,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "horario_trabalho_id")
    var horarioTrabalho: HorarioTrabalho,

    var dataContratacao: LocalDateTime,

    var dataDesligamento: LocalDateTime?

) : Usuario(id,nome, senha, email, login, empresa, ativo, cpf, telefone) {
}