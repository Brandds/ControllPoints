package ControllPoints.com.mapper

import ControllPoints.com.dto.CargoDTO
import ControllPoints.com.model.Cargo
import ControllPoints.com.model.Empresa


fun Cargo.toDTO(): CargoDTO {
    return CargoDTO(
        id = this.id,
        nome = this.nome,
        descricao = this.descricao,
        valorHoraRef = this.valorHoraRef,
        empresaId = this.empresa.id ?: throw IllegalStateException("ID da empresa não pode ser nulo")
    )
}

fun CargoDTO.toEntity(empresa: Empresa): Cargo {
    return Cargo(
        id = this.id,
        nome = this.nome,
        descricao = this.descricao,
        valorHoraRef = this.valorHoraRef,
        empresa = empresa, // Objeto Empresa completo passado como parâmetro
        listaColaboradoresCargo = listOf() // Correto, esta lista não é preenchida a partir do DTO
    )
}