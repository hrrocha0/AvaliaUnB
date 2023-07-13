package me.hrrocha0.avaliaunb.models

data class ProfessorModel(
    val id: Int,
    val matricula: String,
    val nome: String,
    val email: String,
) : Model {
    override fun toMap() = mapOf("id" to id, "matricula" to matricula, "nome" to nome, "email" to email)
}