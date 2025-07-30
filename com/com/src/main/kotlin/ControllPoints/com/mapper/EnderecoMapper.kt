package ControllPoints.com.mapper

import ControllPoints.com.dto.EnderecoDTO
import ControllPoints.com.model.Endereco

fun EnderecoDTO.toEntity() : Endereco{
    return Endereco(
        id = this.id,
        logradouro = this.logradouro,
        complemento = this.complemento,
        bairro = this.bairro,
        municipio = this.municipio,
        uf = this.uf,
        cep = this.cep,
    )
}

fun Endereco.toDto() : EnderecoDTO {
    return EnderecoDTO(
        id = this.id,
        logradouro = this.logradouro,
        complemento = this.complemento,
        bairro = this.bairro,
        municipio = this.municipio,
        uf = this.uf,
        cep = this.cep
    )
}