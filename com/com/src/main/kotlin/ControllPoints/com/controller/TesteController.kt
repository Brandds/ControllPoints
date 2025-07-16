package ControllPoints.com.controller

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TesteController (
    private val passwordEncoder: PasswordEncoder

) {
    @GetMapping("/testar-senha")
    fun testarSenhaManual() {
        val novoHashGerado = passwordEncoder.encode("123456")
        println("===============================================================")
        println("USE ESTE HASH NO SEU BANCO DE DADOS: $novoHashGerado")
        println("===============================================================")
    }
}