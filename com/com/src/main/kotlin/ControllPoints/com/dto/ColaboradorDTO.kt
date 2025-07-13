package ControllPoints.com.dto

import ControllPoints.com.base.BaseDTO
import java.time.LocalDateTime

class ColaboradorDTO(
    id : Long?,
    val nome: String,
    val email: String,
    val login: String,
    val cpf: String,
    var telefone: String? = null,

    val ativo: Boolean,

    val empresaId: Long,
    val cargoId: Long,
    val horarioTrabalhoDTO: HorarioTrabalhoDTO,

    var valorHora: Double,
    var salarioBruto: Double,

    val dataContratacao: LocalDateTime,
    val dataDesligamento: LocalDateTime? = null,
    val senha : String
) : BaseDTO(id){}
