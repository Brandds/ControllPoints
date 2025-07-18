package ControllPoints.com.repository

import ControllPoints.com.base.BaseRepository
import ControllPoints.com.model.Colaborador
import ControllPoints.com.model.Empresa
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface EmpresaRepository : BaseRepository<Empresa, Long>{
    fun  findByEmail(cpf : String) : Optional<Empresa>
}