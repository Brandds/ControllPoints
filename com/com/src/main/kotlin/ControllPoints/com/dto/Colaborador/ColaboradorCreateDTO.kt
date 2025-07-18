package ControllPoints.com.dto.Colaborador

import ControllPoints.com.dto.CargoDTO
import ControllPoints.com.dto.EmpresaDTO
import ControllPoints.com.dto.HorarioTrabalhoDTO
import java.time.LocalDateTime

class ColaboradorCreateDTO(
    val nome: String,
    val email: String,
    val cpf: String,
    var telefone: String? = null,
    var empresaDTO: EmpresaDTO? = null,
    var valorHora: Double,
    var salarioBruto: Double,
    val dataContratacao: LocalDateTime,
    val dataDesligamento: LocalDateTime? = null,
    var senha : String,
    val cargoDTO : CargoDTO,
    val horarioTrabalhoDTO: HorarioTrabalhoDTO
    ) {
}