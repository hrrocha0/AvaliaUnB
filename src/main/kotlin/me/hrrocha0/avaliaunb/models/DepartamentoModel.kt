package me.hrrocha0.avaliaunb.models

data class DepartamentoModel(
    val codigo: Int,
    val nome: String,
) : Model {
    override fun toMap() = mapOf("codigo" to codigo, "nome" to nome)
}