package me.hrrocha0.avaliaunb.models

data class DepartamentoModel(
    val id: Int,
    val sigla: String,
    val nome: String,
) : Model {
    override fun toMap() = mapOf("id" to id, "sigla" to sigla, "nome" to nome)
}