package ControllPoints.com.controller

import ControllPoints.com.Security.Jwt.DTO.JwtResponse
import ControllPoints.com.Security.Jwt.DTO.LoginRequest
import ControllPoints.com.Security.Jwt.JwtTokenService
import ControllPoints.com.Security.service.UserDetailsImpl
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/teste")
@Tag(name = "Autenticação", description = "Endpoint para realizar o login e obter o token JWT.")
class AuthController (
    private val authenticationManager: AuthenticationManager,
    private val jwtTokenService: JwtTokenService
) {
    @PostMapping("/login")
    @Operation(summary = "Autenticar usuário", description = "Realiza o login e retorna um token JWT.")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Autenticação bem-sucedida"),
        ApiResponse(responseCode = "403", description = "Credenciais inválidas")
    ])
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<JwtResponse> {
        // 1. Cria um objeto de autenticação com as credenciais recebidas
        val authenticationToken = UsernamePasswordAuthenticationToken(loginRequest.email, loginRequest.senha)

        // 2. O AuthenticationManager valida as credenciais. Se forem inválidas, ele lança uma exceção.
        val authentication = authenticationManager.authenticate(authenticationToken)

        // 3. Se a autenticação foi bem-sucedida, pega os detalhes do usuário
        val userDetails = authentication.principal as UserDetailsImpl

        // 4. Gera o token JWT com base nos detalhes do usuário
        val token = jwtTokenService.generateToken(userDetails)

        // 5. Retorna o token em uma resposta 200 OK
        return ResponseEntity.ok(JwtResponse(token))
    }
}