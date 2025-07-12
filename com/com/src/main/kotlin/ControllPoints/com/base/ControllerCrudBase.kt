package ControllPoints.com.base

import org.springframework.web.bind.annotation.*

abstract class BaseCrudController<T, DTO>(
    private val service: BaseService<T, DTO>
) {

    @GetMapping
    open fun buscarTodosAtivos(): List<DTO> = service.listarNaoExcluidos()

    @GetMapping("/buscar_todos")
    open fun buscarTodosIncluindoExcluidos(): List<DTO> = service.listarExcluidos()

    @GetMapping("/{id}")
    open fun buscarPorId(@PathVariable id: Long): DTO = service.buscarPorId(id)

    @PutMapping("/{id}")
    open fun atualizar(@PathVariable id: Long, @RequestBody dto: DTO): DTO {
        return service.atualizar(id, dto)
    }

    @PostMapping
    open fun salvar(@RequestBody dto: DTO): DTO = service.salvar(dto)

    @DeleteMapping("/{id}")
    open fun deletar(@PathVariable id: Long): Boolean = service.deletarLogicamente(id)
}