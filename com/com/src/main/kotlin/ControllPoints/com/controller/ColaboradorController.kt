package ControllPoints.com.controller

import ControllPoints.com.base.BaseCrudController
import ControllPoints.com.dto.ColaboradorDTO
import ControllPoints.com.dto.EmpresaDTO
import ControllPoints.com.model.Colaborador
import ControllPoints.com.service.ServiceImpl.ColaboradorServiceImpl
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/colaboradores")
class ColaboradorController(
    private val colaoradorservice: ColaboradorServiceImpl
) : BaseCrudController<Colaborador, ColaboradorDTO>(colaoradorservice) {

    @Operation(summary = "Cadastra entidade", description = "Cadastrar a entidade em sua devida tabela")
    @PostMapping("/cadastrar")
    override fun salvar(@RequestBody dto: ColaboradorDTO): ColaboradorDTO {
        return colaoradorservice.salvar(dto);
    }
}