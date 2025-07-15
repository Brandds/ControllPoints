package ControllPoints.com.Security.Jwt.DTO

data class LoginRequest(
    val email: String,
    val senha: String
) {
}