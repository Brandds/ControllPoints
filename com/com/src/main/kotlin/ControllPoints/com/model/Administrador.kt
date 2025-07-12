package ControllPoints.com.model

class Administrador(
    nome:String,
    senha: String,
    email: String,
    login: String,
    empresa: Empresa,
    ativo: Boolean,
    cpf: String,
    telefone:String?

): Usuario(nome,senha,email,login,empresa,ativo, cpf, telefone) {
}