package ControllPoints.com.service

import ControllPoints.com.dto.Colaborador.ColaboradorCreateDTO
import ControllPoints.com.dto.ColaboradorDTO

interface ColaboradorService{
    fun cadastrar(dto : ColaboradorCreateDTO) : ColaboradorDTO
}