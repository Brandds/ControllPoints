package ControllPoints.com.service.ServiceImpl

import ControllPoints.com.base.BaseService
import ControllPoints.com.dto.CargoDTO
import ControllPoints.com.model.Cargo
import org.springframework.stereotype.Service

@Service
class CargoServiceImpl : BaseService<Cargo, CargoDTO> {
    override fun listarNaoExcluidos(): List<CargoDTO> {
        TODO("Not yet implemented")
    }

    override fun listarExcluidos(): List<CargoDTO> {
        TODO("Not yet implemented")
    }

    override fun buscarPorId(id: Long): CargoDTO {
        TODO("Not yet implemented")
    }

    override fun salvar(dto: CargoDTO): CargoDTO {
        TODO("Not yet implemented")
    }

    override fun deletarLogicamente(id: Long): Boolean {
        TODO("Not yet implemented")
    }

    override fun atualizar(id: Long, dto: CargoDTO): CargoDTO {
        TODO("Not yet implemented")
    }

    override fun recuperarPorId(id: Long): Cargo {
        TODO("Not yet implemented")
    }
}