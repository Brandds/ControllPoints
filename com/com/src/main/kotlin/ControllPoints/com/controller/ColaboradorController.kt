package ControllPoints.com.controller

import ControllPoints.com.base.BaseCrudController
import ControllPoints.com.dto.Colaborador.ColaboradorCreateDTO
import ControllPoints.com.dto.ColaboradorDTO
import ControllPoints.com.dto.EmpresaDTO
import ControllPoints.com.model.Colaborador
import ControllPoints.com.service.ServiceImpl.ColaboradorServiceImpl
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/colaboradores")
class ColaboradorController(
    private val colaoradorservice: ColaboradorServiceImpl
) : BaseCrudController<Colaborador, ColaboradorDTO>(colaoradorservice) {

    @Operation(summary = "Cadastra entidade/Não mais utilizados", description = "Não mais utilizados")
    @PostMapping("/cadastrar")
    override fun salvar(@RequestBody dto: ColaboradorDTO): ColaboradorDTO {
        return colaoradorservice.salvar(dto);
    }

    @Operation(summary = "Cadastra entidade/Não mais utilizados", description = "Não mais utilizados")
    @PostMapping("/cadastrarColaborador")
     fun cadastroColaborador(@RequestBody dto: ColaboradorCreateDTO): ResponseEntity<ColaboradorDTO> {
        val colaboradorSalvoDto =  colaoradorservice.cadastrar(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorSalvoDto);
    }
}