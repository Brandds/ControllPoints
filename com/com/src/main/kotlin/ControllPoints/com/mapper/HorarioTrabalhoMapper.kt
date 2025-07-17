package ControllPoints.com.mapper

import ControllPoints.com.dto.HorarioTrabalhoDTO
import ControllPoints.com.model.HorarioTrabalho


fun HorarioTrabalho.toDTO(): HorarioTrabalhoDTO {
    return HorarioTrabalhoDTO(
      id = this.id

    )
}

fun HorarioTrabalhoDTO.toEntity() : HorarioTrabalho{
    return HorarioTrabalho(
        id = this.id
    )
}