package ControllPoints.com.mapper

import ControllPoints.com.dto.ColaboradorDTO
import ControllPoints.com.model.Colaborador

fun ColaboradorDTO.toEntityCreate() : Colaborador {
    return Colaborador(
        nome = this.nome,
        cpf = this.cpf,
        ativo = this.ativo,
        email = this.email,
        login = this.login,
        telefone = this.telefone,
        empresa = this.empresaDTO.toEntity(),
        id = this.id,
        senha = this.senha,
        cargo = this.cargoDTO.toEntity(),
        valorHora = this.valorHora,
        salarioBruto = this.salarioBruto,
        horarioTrabalho = this.horarioTrabalhoDTO.toEntity(),
        dataContratacao = this.dataContratacao,
        dataDesligamento = this.dataDesligamento,
    )
}