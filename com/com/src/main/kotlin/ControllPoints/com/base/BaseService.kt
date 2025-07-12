package ControllPoints.com.base

interface BaseService<T, DTO> {

    fun listarNaoExcluidos() : List<DTO>
    fun listarExcluidos(): List<DTO>
    fun buscarPorId(id: Long): DTO
    fun salvar(dto: DTO): DTO
    fun deletarLogicamente(id: Long): Boolean
    fun atualizar(id: Long, dto:DTO): DTO
}