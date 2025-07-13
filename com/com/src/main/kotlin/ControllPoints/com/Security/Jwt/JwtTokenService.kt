package ControllPoints.com.Security.Jwt

import ControllPoints.com.Security.service.UserDetailsImpl
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTCreationException
import com.auth0.jwt.exceptions.JWTVerificationException
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

@Service
class JwtTokenService {

    companion object {
        private const val SECRET_KEY = "4Z^XrroxR@dWxqf\$mTTKwW\$!@#qGr4P"
        private const val ISSUER = "pizzurg-api" // Emissor do token
    }

    fun generateToken(user: UserDetailsImpl): String {
        try {
            val algorithm = Algorithm.HMAC256(SECRET_KEY)
            return JWT.create()
                .withIssuer(ISSUER)
                .withIssuedAt(creationDate())
                .withExpiresAt(expirationDate())
                .withSubject(user.username) // Acesso à propriedade 'username' diretamente
                .sign(algorithm)
        } catch (exception: JWTCreationException) {
            // A sintaxe do try-catch em Kotlin é um pouco diferente
            throw JWTCreationException("Erro ao gerar token.", exception)
        }
    }
    fun getSubjectFromToken(token: String): String {
        try {
            val algorithm = Algorithm.HMAC256(SECRET_KEY)
            return JWT.require(algorithm)
                .withIssuer(ISSUER)
                .build()
                .verify(token)
                .subject // Acesso à propriedade 'subject' diretamente
        } catch (exception: JWTVerificationException) {
            throw JWTVerificationException("Token inválido ou expirado.")
        }
    }
    private fun creationDate(): Instant = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toInstant()

    private fun expirationDate(): Instant = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).plusHours(4).toInstant()
}