package ControllPoints.com.mapper

import ControllPoints.com.dto.EmpresaDTO
import ControllPoints.com.model.Empresa
import java.time.LocalDate

fun  EmpresaDTO.toEntityCreate() : Empresa {
    return Empresa(
        cnpj = this.cnpj,
        razaoSocial = this.razaoSocial,
        nomeFantasia = this.nomeFantasia,
        telefone = this.telefone,
        dataCadastro = LocalDate.now(),
        senha =  this.senha,
        email = this.email
    )
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
        email = this.email
    )
}

fun EmpresaDTO.toEntity() : Empresa {
    return Empresa(
        cnpj = this.cnpj,
        razaoSocial = this.razaoSocial,
        nomeFantasia = this.nomeFantasia,
        telefone = this.telefone,
        dataCadastro = this.dataCadastro,
        email = this.email,
        senha = this.senha
    )
}