package ControllPoints.com.mapper

import ControllPoints.com.dto.CargoDTO
import ControllPoints.com.model.Cargo

fun Cargo.toDTO() : CargoDTO{
    return CargoDTO(
        id = this.id,
        nome = this.nome,
        descricao = this.descricao,
        nivel = this.nivel,
        salarioBase = this.salarioBase,
        ativo = this.ativo,
        empresa = this.empresa.toDTO(),
        listaRole = this.listaRole
    )
}

fun CargoDTO.toEntity() : Cargo{
    return Cargo(
        id = this.id,
        nome = this.nome,
        descricao = this.descricao,
        nivel = this.nivel,
        salarioBase= this.salarioBase,
        empresa = this.empresa.toEntity()
    )
}