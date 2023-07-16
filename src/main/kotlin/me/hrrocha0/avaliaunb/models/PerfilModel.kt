package me.hrrocha0.avaliaunb.models

data class PerfilModel(
    val matricula: String,
    val nome: String,
    val email: String,
    val administrador: Boolean,
    val curso: String,
) : Model {
    override fun toMap() = mapOf(
        "matricula" to matricula,
        "nome" to nome,
        "email" to email,
        "administrador" to administrador,
        "curso" to curso,
    )
}
