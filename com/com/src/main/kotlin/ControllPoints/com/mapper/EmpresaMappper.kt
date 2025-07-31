package ControllPoints.com.mapper

import ControllPoints.com.dto.EmpresaDTO
import ControllPoints.com.model.Empresa
import ControllPoints.com.model.Role
import java.time.LocalDate

private fun mapCampos(dto: EmpresaDTO, empresa: Empresa) {
    empresa.cnpj = dto.cnpj
    empresa.razaoSocial = dto.razaoSocial
    empresa.nomeFantasia = dto.nomeFantasia
    empresa.telefone = dto.telefone
    empresa.dataCadastro = dto.dataCadastro
    empresa.senha = dto.senha
    empresa.email = dto.email
    empresa.tipo = dto.tipo
    empresa.naturezaJuridica = dto.naturezaJuridica
    empresa.abertura = dto.abertura
    empresa.situacaoEmpresa = dto.situacaoEmpresa
    empresa.capitalSocial = dto.capitalSocial
    empresa.listaRole = dto.listaRole
    empresa.endereco = dto.enderecoDTO?.toEntity()
}


fun EmpresaDTO.toEntityCreate(): Empresa {
    return Empresa().apply {
        capitalSocial = this@toEntityCreate.capitalSocial
        cnpj = this@toEntityCreate.cnpj
        razaoSocial = this@toEntityCreate.razaoSocial
        nomeFantasia = this@toEntityCreate.nomeFantasia
        tipo = this@toEntityCreate.tipo
        naturezaJuridica = this@toEntityCreate.naturezaJuridica
        situacaoEmpresa = this@toEntityCreate.situacaoEmpresa
        senha = this@toEntityCreate.senha
        email = this@toEntityCreate.email
        telefone = this@toEntityCreate.telefone
        dataCadastro = this@toEntityCreate.dataCadastro
        listaRole = this@toEntityCreate.listaRole
    }
}




fun Empresa.toDTO() : EmpresaDTO {
    return EmpresaDTO(
        id = this.id,
        cnpj = this.cnpj,
        razaoSocial = this.razaoSocial,
        nomeFantasia = this.nomeFantasia,
        telefone = this.telefone,
        dataCadastro = this.dataCadastro,
        senha = "",
        email = this.email,
        enderecoDTO = this.endereco?.toDto(),
        tipo = this.tipo,
        naturezaJuridica = this.naturezaJuridica,
        abertura = this.abertura,
        situacaoEmpresa = this.situacaoEmpresa,
        capitalSocial = this.capitalSocial,
        listaRole = this.listaRole
    )
}

fun EmpresaDTO.toEntity(): Empresa {
    val empresa = Empresa()
    mapCampos(this, empresa)
    return empresa
}

