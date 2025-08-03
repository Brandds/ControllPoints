package ControllPoints.com.controller

import ControllPoints.com.base.BaseCrudController
import ControllPoints.com.dto.EmpresaDTO
import ControllPoints.com.integracoes.ReceitaWSResponse
import ControllPoints.com.model.Empresa
import ControllPoints.com.service.ServiceImpl.EmpresaServiceImpl
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/empresa")
class EmpresaController(
    private val empresaService : EmpresaServiceImpl
) : BaseCrudController<Empresa, EmpresaDTO>(empresaService) {

    @Operation(summary = "Não utilizado", description = "Cadastrar a entidade em sua devida tabela")
    @PostMapping("/cadastroNot")
    override fun salvar(@RequestBody dto: EmpresaDTO): EmpresaDTO {
        return empresaService.salvar(dto);
    }

    @Operation(summary = "Busca empresa", description = "Busca empresa pelo CNPJ")
    @PostMapping("/buscaCNPJ/{cnpj}")
    suspend fun buscaCNPJ(@PathVariable cnpj : String): ReceitaWSResponse? {
        return empresaService.buscaCNPJ(cnpj);
    }
}