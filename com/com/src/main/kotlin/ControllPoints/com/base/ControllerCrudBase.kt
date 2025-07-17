package ControllPoints.com.base

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.*

abstract class BaseCrudController<T, DTO>(
    private val service: BaseService<T, DTO>
) {
    @Operation(summary = "Busca todos registros ativos", description = "Busca todos registros da entidade ativos")
    @GetMapping
    open fun buscarTodosAtivos(): List<DTO> = service.listarNaoExcluidos()

    @Operation(summary = "Busca todos registros excluidos", description = "Busca todos registros da entidade excluida")
    @GetMapping("/buscar_todos")
    open fun buscarTodosIncluindoExcluidos(): List<DTO> = service.listarExcluidos()

    @Operation(summary = "Busca a entidade", description = "Busca a entidade pelo id salvo na tabela")
    @GetMapping("/{id}")
    open fun buscarPorId(@PathVariable id: Long): DTO = service.buscarPorId(id)

    @Operation(summary = "Atualiza a entidade", description = "Atualizar a entidade no banco de dados")
    @PutMapping("/{id}")
    open fun atualizar(@PathVariable id: Long, @RequestBody dto: DTO): DTO {
        return service.atualizar(id, dto)
    }
    @Operation(summary = "Cadastra entidade", description = "Cadastrar a entidade em sua devida tabela")
    @PostMapping("/cadastrar")
    open fun salvar(@RequestBody dto: DTO): DTO = service.salvar(dto)

    @Operation(summary = "Deleta a entidade", description = "Deleta a entidade pelo id")
    @DeleteMapping("/{id}")
    open fun deletar(@PathVariable id: Long): Boolean = service.deletarLogicamente(id)
}