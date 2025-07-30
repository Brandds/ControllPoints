package ControllPoints.com.service

import ControllPoints.com.dto.EmpresaDTO
import ControllPoints.com.integracoes.ReceitaWSResponse

interface EmpresaService {
    suspend fun buscaCNPJ(cnpj : String) : ReceitaWSResponse?
}