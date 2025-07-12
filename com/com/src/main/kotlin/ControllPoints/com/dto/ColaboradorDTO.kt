package ControllPoints.com.dto

import java.time.LocalDateTime

data class ColaboradorDTO(
    val id: Long? = null,

    val nome: String,
    val email: String,
    val login: String,
    val cpf: String,
    var telefone: String? = null,

    val ativo: Boolean,

    val empresaId: Long,
    val cargoId: Long,
    val horarioTrabalhoId: Long,

    var valorHora: Double,
    var salarioBruto: Double,

    val dataContratacao: LocalDateTime,
    val dataDesligamento: LocalDateTime? = null
)
