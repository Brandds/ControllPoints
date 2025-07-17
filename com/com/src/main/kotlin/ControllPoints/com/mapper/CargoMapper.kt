package ControllPoints.com.mapper

import ControllPoints.com.dto.CargoDTO
import ControllPoints.com.model.Cargo

fun Cargo.toDTO() : CargoDTO{
    return CargoDTO(
        id = this.id,
        nome = this.nome
    )
}

fun CargoDTO.toEntity() : Cargo{
    return Cargo(
        id = this.id,
        nome = this.nome
    )
}