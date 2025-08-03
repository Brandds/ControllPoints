package ControllPoints.com.mapper

import ControllPoints.com.integracoes.IBGEEstadosResponse


fun IBGEEstadosResponse.isAllNull(): Boolean {
    return listOf(
        nome,
        id,
        sigla
    ).all { it == null }
}
