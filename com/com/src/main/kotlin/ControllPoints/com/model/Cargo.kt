package ControllPoints.com.model

import ControllPoints.com.base.BaseEntity
import jakarta.persistence.Entity

@Entity
class Cargo(
    id: Long? = null,
    val nome :String
): BaseEntity(id) {
}