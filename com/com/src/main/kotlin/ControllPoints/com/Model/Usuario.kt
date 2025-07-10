package ControllPoints.com.Model

import ControllPoints.com.Base.BaseEntity
import jakarta.persistence.Entity

@Entity
class Usuario  (
    val nome: String
) : BaseEntity() {

}