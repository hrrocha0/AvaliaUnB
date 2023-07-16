package me.hrrocha0.avaliaunb.models

data class EstudanteModel(
    val matricula: String,
    val nome: String,
    val email: String,
    val senha: String,
    val administrador: Boolean,
    val codigoCurso: Int,
) : Model {
    override fun toMap() = mapOf(
        "matricula" to matricula,
        "nome" to nome,
        "email" to email,
        "senha" to senha,
        "admin" to administrador,
        "codigo_curso" to codigoCurso
    )
}