package ControllPoints.com.repository

import ControllPoints.com.base.BaseRepository
import ControllPoints.com.model.Colaborador
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ColaboradorRepository : BaseRepository<Colaborador, Long>, JpaRepository<Colaborador, Long> {
    @EntityGraph(attributePaths = ["listaRole"])
    fun  findByEmail(cpf : String) : Optional<Colaborador>;
}