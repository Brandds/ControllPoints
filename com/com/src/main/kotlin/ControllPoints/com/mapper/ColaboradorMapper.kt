package ControllPoints.com.mapper

import ControllPoints.com.dto.Colaborador.ColaboradorCreateDTO
import ControllPoints.com.dto.ColaboradorDTO
import ControllPoints.com.model.Colaborador

fun ColaboradorCreateDTO.toEntityCreate() : Colaborador {
    return Colaborador(
        nome = this.nome,
        cpf = this.cpf,
        ativo = true,
        email = this.email,
        telefone = this.telefone,
        empresa = this.empresaDTO!!.toEntity(),
        senha = this.senha,
        cargo = this.cargoDTO.toEntity(),
        valorHora = this.valorHora,
        salarioBruto = this.salarioBruto,
        horarioTrabalho = this.horarioTrabalhoDTO.toEntity(),
        dataContratacao = this.dataContratacao,
        dataDesligamento = this.dataDesligamento,
        listaRole = this.listaRole
    )
}

fun Colaborador.toDTO() : ColaboradorDTO{
    return ColaboradorDTO(
        nome = this.nome,
        email = this.email,
        login = this.login,
        cpf = this.cpf,
        ativo = this.ativo,
        cargoDTO = this.cargo.toDTO(),
        horarioTrabalhoDTO = this.horarioTrabalho.toDTO(),
        valorHora = this.valorHora,
        salarioBruto = this.salarioBruto,
        dataContratacao = this.dataContratacao,
        senha = "",
        id = this.id,
        telefone = this.telefone,
        dataDesligamento = this.dataDesligamento
    )
}