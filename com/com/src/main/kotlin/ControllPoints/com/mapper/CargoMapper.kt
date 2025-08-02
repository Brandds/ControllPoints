package ControllPoints.com.mapper

import ControllPoints.com.dto.CargoDTO
import ControllPoints.com.model.Cargo
import ControllPoints.com.model.Empresa


fun Cargo.toDTO(): CargoDTO {
    return CargoDTO(
        id = this.id,
        nome = this.nome,
        descricao = this.descricao,
        nivel = this.nivel,
        salarioBase = this.salarioBase,
        ativo = this.ativo,
        empresa = this.empresa.toDTO(),
        listaRole = this.listaRole
        valorHoraRef = this.valorHoraRef,
        empresaId = this.empresa.id ?: throw IllegalStateException("ID da empresa não pode ser nulo")
    )
}

fun CargoDTO.toEntity(empresa: Empresa): Cargo {
    return Cargo(
        id = this.id,
        nome = this.nome,
        descricao = this.descricao,
        nivel = this.nivel,
        salarioBase= this.salarioBase,
        empresa = this.empresa.toEntity()
        valorHoraRef = this.valorHoraRef,
        empresa = empresa, 
        listaColaboradoresCargo = listOf()
    )
}