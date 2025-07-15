package ControllPoints.com.service.ServiceImpl

import ControllPoints.com.base.BaseServiceImpl
import ControllPoints.com.dto.HorarioTrabalhoDTO
import ControllPoints.com.model.HorarioTrabalho
import ControllPoints.com.repository.HorarioTrabalhoRepository
import org.springframework.stereotype.Service

@Service
class HorarioTrabalhoServiceImpl(
    private val repository: HorarioTrabalhoRepository
) : BaseServiceImpl<HorarioTrabalho, HorarioTrabalhoDTO>(repository) {

    override fun mapToDTO(entity: HorarioTrabalho): HorarioTrabalhoDTO {
        TODO("Not yet implemented")
    }

    override fun mapToEntity(dto: HorarioTrabalhoDTO): HorarioTrabalho {
        TODO("Not yet implemented")
    }

    override fun antesDeAtualizar(
        entity: HorarioTrabalho,
        dto: HorarioTrabalhoDTO
    ): HorarioTrabalho {
        TODO("Not yet implemented")
    }
}