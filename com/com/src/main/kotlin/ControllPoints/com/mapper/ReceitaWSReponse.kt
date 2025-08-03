package ControllPoints.com.mapper

import ControllPoints.com.integracoes.ReceitaWSResponse

fun ReceitaWSResponse.isAllNull(): Boolean {
    return listOf(
        nome,
        fantasia,
        cnpj,
        abertura,
        tipo,
        natureza_juridica,
        logradouro,
        numero,
        complemento,
        bairro,
        municipio,
        uf,
        cep,
        telefone,
        email,
        situacao,
        capital_social
    ).all { it == null }
}
