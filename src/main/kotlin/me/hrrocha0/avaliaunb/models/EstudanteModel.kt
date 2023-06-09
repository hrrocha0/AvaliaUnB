package me.hrrocha0.avaliaunb.models

data class EstudanteModel(
    val matricula: String,
    val nome: String,
    val email: String,
    val senha: String,
    val admin: Boolean,
    val idCurso: Int,
) : Model {
    override fun toMap() = mapOf(
        "matricula" to matricula,
        "nome" to nome,
        "email" to email,
        "senha" to senha,
        "admin" to admin,
        "id_curso" to idCurso
    )
}