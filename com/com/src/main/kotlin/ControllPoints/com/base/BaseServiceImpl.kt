package ControllPoints.com.base

import ControllPoints.com.exception.EntidadeNaoEncontradaException
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

abstract class BaseServiceImpl<T : BaseEntity, DTO>(
    private val repository: JpaRepository<T, Long>
) : BaseService<T, DTO> {

    override fun listarNaoExcluidos(): List<DTO> {
        return repository.findAll()
            .filter { it.deleteAt == null }
            .map { mapToDTO(it) }
    }

    override fun listarExcluidos(): List<DTO> {
        return repository.findAll()
            .filter { it.deleteAt != null }
            .map { mapToDTO(it) }
    }

    override fun buscarPorId(id: Long): DTO {
        val entidade = repository.findById(id)
            .orElseThrow { EntidadeNaoEncontradaException("Não foi possível localizar a entidade no sistema") }
        return mapToDTO(entidade)
    }

    override fun atualizar(id: Long, dto: DTO): DTO {
        val entidadeExistente = repository.findById(id)
            .orElseThrow { RuntimeException("Não foi possível localizar a entidade no sistema") }

        val novaEntidade = antesDeAtualizar(entidadeExistente, dto)
        return mapToDTO(repository.save(novaEntidade))
    }

    override fun deletarLogicamente(id: Long): Boolean {
        var entidadeExistente = repository.findById(id)
            .orElseThrow { RuntimeException("Não foi possivel localizar a entidade no sistema") }
        entidadeExistente.deleteAt = LocalDateTime.now()
        repository.save(entidadeExistente)
        return true
    }

    override fun salvar(dto: DTO): DTO {
        val dtoPreparado = antesDeSalvar(dto)
        val entity = mapToEntity(dtoPreparado)
        val salvo = repository.save(entity)
        return mapToDTO(salvo)
    }

    override fun recuperarPorId(id: Long): T {
        return repository.findById(id)
            .orElseThrow{ RuntimeException("Näo foi possivel recuperar a entidade no banco do sistema") }
    }

    abstract fun mapToDTO(entity: T): DTO

    abstract fun mapToEntity(dto: DTO): T

    abstract fun antesDeAtualizar(entity: T, dto: DTO): T

    open fun antesDeSalvar(dto: DTO): DTO = dto
}
