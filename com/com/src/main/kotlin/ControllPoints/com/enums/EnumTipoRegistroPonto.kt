package ControllPoints.com.enums

enum class TipoRegistroPonto(val codigo: String, val descricao: String) {
    ENTRADA("EN", "Entrada no expediente"),
    INICIO_PAUSA("IP", "Início da pausa"),
    FIM_PAUSA("FP", "Fim da pausa"),
    SAIDA("SA", "Saída do expediente");

    companion object {
        fun fromCodigo(codigo: String): TipoRegistroPonto? {
            return TipoRegistroPonto.entries.find { it.codigo == codigo.uppercase() }
        }
    }
}
