package ControllPoints.com.service.ServiceImpl

import ControllPoints.com.mapper.toEntityCreate
import ControllPoints.com.base.BaseServiceImpl
import ControllPoints.com.dto.EmpresaDTO
import ControllPoints.com.integracoes.ReceitaWSResponse
import ControllPoints.com.integracoes.ReceitaWsServiceImpl
import ControllPoints.com.mapper.toDTO
import ControllPoints.com.model.Empresa
import ControllPoints.com.repository.EmpresaRepository
import ControllPoints.com.service.EmpresaService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(
    private val repository: EmpresaRepository,
    private val receitaWsServiceImpl: ReceitaWsServiceImpl
) : BaseServiceImpl<Empresa, EmpresaDTO>(repository), EmpresaService {

    override  fun mapToEntity(dto: EmpresaDTO): Empresa {
        val consultaCnpj = receitaWsServiceImpl.buscarEmpresaPorCnpj(dto.cnpj)
        if(consultaCnpj == null)
            throw IllegalArgumentException("CNPJ invalido, não foi encontrado!")
        consultaCnpj.toString();
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

    override suspend fun create(dto: EmpresaDTO): EmpresaDTO {
        val consultaReceita = receitaWsServiceImpl.buscarEmpresaPorCnpj(dto.cnpj)
        if(consultaReceita == null)
            throw IllegalArgumentException("Cpnj invalido, não encontrado na base!")

        print(consultaReceita.toString())
        val entity = dto.toEntityCreate()
        repository.save(entity)
        return entity.toDTO()
    }
}