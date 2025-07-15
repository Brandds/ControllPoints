package ControllPoints.com.controller

import ControllPoints.com.base.BaseCrudController
import ControllPoints.com.dto.ColaboradorDTO
import ControllPoints.com.model.Colaborador
import ControllPoints.com.service.ServiceImpl.ColaboradorServiceImpl
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/colaboradores")
class ColaboradorController(
    service: ColaboradorServiceImpl
) : BaseCrudController<Colaborador, ColaboradorDTO>(service) {
}