package ControllPoints.com.controller

import ControllPoints.com.integracoes.IBGEEstadosResponse
import ControllPoints.com.integracoes.IBGEServiceImpl
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/IBGE")
class IBGEController(
    private val ibgeServiceImpl: IBGEServiceImpl
) {

    @Operation(summary = "Busca estados", description = "Busca todos estados registrado no IBGE")
    @GetMapping("/estados")
    suspend  fun getEstados() : List<IBGEEstadosResponse>{
        return ibgeServiceImpl.buscarEstadoDoBrasil()
    }
}