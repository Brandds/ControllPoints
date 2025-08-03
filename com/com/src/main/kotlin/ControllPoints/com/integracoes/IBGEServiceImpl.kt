package ControllPoints.com.integracoes

import ControllPoints.com.mapper.isAllNull
import kotlinx.coroutines.reactive.awaitLast
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

data class IBGEEstadosResponse(
    val id : Long,
    val sigla : String,
    val nome : String
)

@Service
class IBGEServiceImpl{

    private val webCliente = WebClient.builder()
        .baseUrl("https://servicodados.ibge.gov.br/api/v1/localidades")
        .build()

    suspend  fun buscarEstadoDoBrasil() : List<IBGEEstadosResponse> {
        return webCliente.get()
            .uri("/estados")
            .retrieve()
            .onStatus({status -> status.is4xxClientError || status.is5xxServerError}){ resp ->
                Mono.error(IllegalArgumentException("Erro na requisição: ${resp.statusCode()}"))
            }
            .bodyToFlux(IBGEEstadosResponse::class.java)
            .collectList()
            .awaitLast()

    }
}