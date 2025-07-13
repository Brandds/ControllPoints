package ControllPoints.com.Mapper

import ControllPoints.com.dto.HorarioTrabalhoDTO
import ControllPoints.com.model.HorarioTrabalho


fun HorarioTrabalho.toDTO(): HorarioTrabalhoDTO {
    return HorarioTrabalhoDTO(
      id = this.id

    )
}