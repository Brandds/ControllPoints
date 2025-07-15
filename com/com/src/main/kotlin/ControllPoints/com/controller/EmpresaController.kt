package ControllPoints.com.controller

import ControllPoints.com.base.BaseCrudController
import ControllPoints.com.dto.EmpresaDTO
import ControllPoints.com.model.Empresa
import ControllPoints.com.service.ServiceImpl.EmpresaServiceImpl
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/empresa")
class EmpresaController(
    service : EmpresaServiceImpl
) : BaseCrudController<Empresa, EmpresaDTO>(service) {
}