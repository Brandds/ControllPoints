package ControllPoints.com.service.ServiceImpl

import ControllPoints.com.Mapper.toDTO
import ControllPoints.com.base.BaseServiceImpl
import ControllPoints.com.dto.ColaboradorDTO
import ControllPoints.com.model.Colaborador
import ControllPoints.com.repository.ColaboradorRepository
import ControllPoints.com.service.ColaboradorService
import ControllPoints.com.service.ServiceImpl.HorarioTrabalhoServiceImpl
import org.springframework.stereotype.Service

@Service
class ColaboradorServiceImpl(
    private val repository: ColaboradorRepository,
    private val empresaService: EmpresaServiceImpl,
    private val cargoService: CargoServiceImpl,
    private val horarioTrabalhoService: HorarioTrabalhoServiceImpl
) : BaseServiceImpl<Colaborador, ColaboradorDTO>(repository), ColaboradorService {

    override fun mapToDTO(entity: Colaborador): ColaboradorDTO {
        return ColaboradorDTO(
            nome = entity.nome,
            email = entity.email,
            login = entity.login,
            cpf = entity.cpf,
            telefone = entity.telefone,
            ativo = entity.ativo,
            empresaId = entity.empresa.id!!,
            cargoId = entity.cargo.id!!,
            horarioTrabalhoDTO = entity.horarioTrabalho.toDTO(),
            valorHora = entity.valorHora,
            salarioBruto = entity.salarioBruto,
            dataContratacao = entity.dataContratacao,
            dataDesligamento = entity.dataDesligamento,
            id = entity.id,
            senha = entity.senha
        )
    }

    override fun mapToEntity(dto: ColaboradorDTO): Colaborador {
        val empresa = empresaService.recuperarPorId(dto.empresaId)
        val cargo = cargoService.recuperarPorId(dto.cargoId)
        val horarioTrabalhoId = dto.horarioTrabalhoDTO.id
            ?: throw IllegalArgumentException("O ID do Horário de Trabalho não pode ser nulo.")

        val hTrabalho = horarioTrabalhoService.recuperarPorId(horarioTrabalhoId)
        return Colaborador(
            id = dto.id,
            nome = dto.nome,
            email = dto.email,
            login = dto.login,
            senha = dto.senha,
            cpf = dto.cpf,
            telefone = dto.telefone!!,
            ativo = dto.ativo,
            empresa = empresa,
            cargo = cargo,
            horarioTrabalho = hTrabalho,
            valorHora = dto.valorHora,
            salarioBruto = dto.salarioBruto,
            dataContratacao = dto.dataContratacao,
            dataDesligamento = dto.dataDesligamento!!
        )
    }


    override fun antesDeAtualizar(entity: Colaborador, dto: ColaboradorDTO): Colaborador {
        TODO("Not yet implemented")
    }
}