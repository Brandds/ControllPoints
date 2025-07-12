package ControllPoints.com.base

import org.springframework.data.jpa.repository.JpaRepository

abstract class BaseServiceImpl<T: BaseEntity, DTO>(
    private val repository: JpaRepository<T, Long>
): BaseService<T, DTO> {

    override fun listarNaoExcluidos(): List<DTO> {
        return repository.findAll().map { mapToDTO(it) }
    }

    override fun listarExcluidos(): List<DTO> {
        return repository.findAll()
            .filter { it.deleteAt == null }
            .map{mapToDTO(it)}
    }

    override fun buscarPorId(id: Long): DTO {
    val entidade = repository.findById(id).orElseThrow{ RuntimeException("Não foi possivel localizar a entidade no sistema") }
        return mapToDTO(entidade)
    }

    override fun atualizar(id: Long, dto: DTO) : DTO{
        val entidadeExistente = repository.findById(id).orElseThrow{ RuntimeException("Não foi possivel localizar a entidade no sistema") }
        val novaEntidade = aplicarAtualizacoes(entidadeExistente, dto)

        return mapToDTO(repository.save(novaEntidade))

    }

    abstract fun salvar(entity:T):DTO

    abstract fun mapToDTO(entity: T):DTO

    abstract fun aplicarAtualizacoes(entity: T, dto: DTO) : T

}