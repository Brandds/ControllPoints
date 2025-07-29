package ControllPoints.com.service

import ControllPoints.com.dto.EmpresaDTO

interface EmpresaService {
    suspend fun create(dto : EmpresaDTO) : EmpresaDTO
}