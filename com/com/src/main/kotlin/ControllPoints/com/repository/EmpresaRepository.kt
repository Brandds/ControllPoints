package ControllPoints.com.repository

import ControllPoints.com.base.BaseRepository
import ControllPoints.com.model.Empresa
import org.springframework.data.jpa.repository.JpaRepository

interface EmpresaRepository : BaseRepository<Empresa, Long>{
}