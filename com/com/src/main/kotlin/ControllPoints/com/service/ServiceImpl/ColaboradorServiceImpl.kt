package ControllPoints.com.service.ServiceImpl

import ControllPoints.com.mapper.toDTO
import ControllPoints.com.base.BaseServiceImpl
import ControllPoints.com.dto.Colaborador.ColaboradorCreateDTO
import ControllPoints.com.dto.ColaboradorDTO
import ControllPoints.com.exception.RecursoJaExistenteException
import ControllPoints.com.mapper.toEntityCreate
import ControllPoints.com.model.Colaborador
import ControllPoints.com.repository.ColaboradorRepository
import ControllPoints.com.service.ColaboradorService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class ColaboradorServiceImpl(
    private val repositoryColaborador: ColaboradorRepository,
    private val empresaService: EmpresaServiceImpl,
    private val cargoService: CargoServiceImpl,
    private val horarioTrabalhoService: HorarioTrabalhoServiceImpl,
    private val passwordEncoder: PasswordEncoder
) : BaseServiceImpl<Colaborador, ColaboradorDTO>(repositoryColaborador), ColaboradorService {

    override fun salvar(dto: ColaboradorDTO): ColaboradorDTO {
//        val senhaHasheada = passwordEncoder.encode(dto.senha);
//        dto.senha = senhaHasheada;
//        val newEntity = dto.toEntityCreate();
//        repositoryColaborador.save(newEntity);
//        return newEntity.toDTO();
        throw NotImplementedError("Este método deve ser implementado pelo serviço concreto.")

    }

    override fun mapToDTO(entity: Colaborador): ColaboradorDTO {
        return ColaboradorDTO(
            nome = entity.nome,
            email = entity.email,
            login = entity.login,
            cpf = entity.cpf,
            telefone = entity.telefone,
            ativo = entity.ativo,
            empresaDTO = entity.empresa.toDTO(),
            cargoDTO = entity.cargo.toDTO(),
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
        val empresaId = requireNotNull(dto.empresaDTO?.id) { "ID da empresa não pode ser nulo" }
        val empresa = empresaService.recuperarPorId(empresaId);
        val cargoId = requireNotNull(dto.cargoDTO.id) { "ID do cargo não pode ser nulo" }
        val cargo = cargoService.recuperarPorId(cargoId);

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

    override fun cadastrar(dto: ColaboradorCreateDTO): ColaboradorDTO {
        if(existColaborador(dto.email))
            throw RecursoJaExistenteException("O e-mail '${dto.email}' já está em uso.")
        val newEntityColaborador = dto.toEntityCreate();
        repositoryColaborador.save(newEntityColaborador)

        return newEntityColaborador.toDTO();
    }

    private fun existColaborador(email : String) : Boolean {
        val colaborador = repositoryColaborador.findByEmail(email);
        if(colaborador.isPresent) return true;

        return false;
    }
}