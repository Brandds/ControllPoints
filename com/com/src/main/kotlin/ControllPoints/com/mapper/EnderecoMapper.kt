package ControllPoints.com.mapper

import ControllPoints.com.dto.EnderecoDTO
import ControllPoints.com.model.Endereco

fun EnderecoDTO.toEntity() : Endereco{
    return Endereco(
        id = this.id
    )
}