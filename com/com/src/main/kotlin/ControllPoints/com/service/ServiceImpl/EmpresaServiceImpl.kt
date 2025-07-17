package ControllPoints.com.service.ServiceImpl

import ControllPoints.com.mapper.toEntityCreate
import ControllPoints.com.base.BaseServiceImpl
import ControllPoints.com.dto.EmpresaDTO
import ControllPoints.com.mapper.toDTO
import ControllPoints.com.model.Empresa
import ControllPoints.com.repository.EmpresaRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(
    private val repository: EmpresaRepository,
) : BaseServiceImpl<Empresa, EmpresaDTO>(repository) {

    override fun mapToEntity(dto: EmpresaDTO): Empresa {
        return dto.toEntityCreate()
    }

    override fun antesDeAtualizar(
        entity: Empresa,
        dto: EmpresaDTO
    ): Empresa {
        TODO("Not yet implemented")
    }

    override fun mapToDTO(entity: Empresa): EmpresaDTO {
        return entity.toDTO();
    }
}