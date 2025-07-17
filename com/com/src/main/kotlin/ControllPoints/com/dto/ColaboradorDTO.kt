package ControllPoints.com.dto

import ControllPoints.com.base.BaseDTO
import java.time.LocalDateTime

class ColaboradorDTO(
    id : Long? = null,
    val nome: String,
    val email: String,
    val login: String,
    val cpf: String,
    var telefone: String? = null,

    val ativo: Boolean,

    var empresaDTO: EmpresaDTO,
    val cargoDTO: CargoDTO,
    val horarioTrabalhoDTO: HorarioTrabalhoDTO,

    var valorHora: Double,
    var salarioBruto: Double,

    val dataContratacao: LocalDateTime,
    val dataDesligamento: LocalDateTime? = null,
    var senha : String
) : BaseDTO(id){}
