package ControllPoints.com.Controller.ExceptionGlobal

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {
    // Exemplo: Captura exceções quando um recurso não é encontrado
    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(ex: NoSuchElementException): ResponseEntity<Map<String, Any>> {
        val body = mapOf(
            "timestamp" to System.currentTimeMillis(),
            "status" to 404,
            "error" to "Not Found",
            "message" to (ex.message ?: "Recurso não encontrado")
        )
        return ResponseEntity.status(404).body(body)
    }
}