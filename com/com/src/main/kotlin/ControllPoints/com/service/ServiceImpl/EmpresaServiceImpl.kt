package ControllPoints.com.service.ServiceImpl

import ControllPoints.com.base.BaseServiceImpl
import ControllPoints.com.dto.EmpresaDTO
import ControllPoints.com.model.Empresa
import ControllPoints.com.repository.EmpresaRepository
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(
    private val repository: EmpresaRepository
) : BaseServiceImpl<Empresa, EmpresaDTO>(repository) {


    override fun mapToDTO(entity: Empresa): EmpresaDTO {
        TODO("Not yet implemented")
    }

    override fun mapToEntity(dto: EmpresaDTO): Empresa {
        TODO("Not yet implemented")
    }

    override fun antesDeAtualizar(
        entity: Empresa,
        dto: EmpresaDTO
    ): Empresa {
        TODO("Not yet implemented")
    }
}