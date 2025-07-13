package ControllPoints.com.model

import ControllPoints.com.base.BaseEntity
import ControllPoints.com.enums.EnumRoleName
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

@Entity
class Role(
    id : Long?,
    @Enumerated(EnumType.STRING)
    val name : EnumRoleName

): BaseEntity(id) {
}