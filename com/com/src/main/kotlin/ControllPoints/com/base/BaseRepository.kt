package ControllPoints.com.base

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface BaseRepository<E, ID>: JpaRepository<E, ID> {
}