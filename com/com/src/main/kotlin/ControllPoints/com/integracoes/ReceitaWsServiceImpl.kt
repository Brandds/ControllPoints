package ControllPoints.com.integracoes

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient


data class ReceitaWSResponse(
    val nome: String?,
    val fantasia: String?,
    val cnpj: String?,
    val abertura: String?,
    val tipo: String?,
    val natureza_juridica: String?,
    val logradouro: String?,
    val numero: String?,
    val complemento: String?,
    val bairro: String?,
    val municipio: String?,
    val uf: String?,
    val cep: String?,
    val telefone: String?,
    val email: String?,
    val situacao: String?,
    val capital_social: String?,
)


@Service
class ReceitaWsServiceImpl {

    private val webClient = WebClient.builder()
        .baseUrl("https://receitaws.com.br/v1")
        .build()

    fun buscarEmpresaPorCnpj(cnpj: String): ReceitaWSResponse? {
        return webClient.get()
            .uri("/cnpj/$cnpj")
            .retrieve()
            .bodyToMono(ReceitaWSResponse::class.java)
            .block()
    }
}