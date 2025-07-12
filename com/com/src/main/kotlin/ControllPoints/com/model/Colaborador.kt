package ControllPoints.com.model

import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
class Colaborador(
    nome: String,
    senha: String,
    email: String,
    login: String,
    empresa: Empresa,
    ativo : Boolean,
    cpf : String,
    telefone: String,

    @ManyToOne(optional = false)
    var cargo: Cargo,

    var valorHora: Double,

    var salarioBruto: Double,

    @ManyToOne
    var horarioTrabalho: HorarioTrabalho,

    var dataContratacao: LocalDateTime,

    var dataDesligamento: LocalDateTime?

) : Usuario(nome, senha, email, login, empresa, ativo, cpf, telefone) {
}