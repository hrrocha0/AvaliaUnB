package me.hrrocha0.avaliaunb.models

data class ProfessorModel(
    val nome: String,
    val codigoDepto: String,
    val codigoPouD: String,
) : Model {
    override fun toMap() = mapOf("nome" to nome, "codigo_depto" to codigoDepto, "codigo_p_ou_d" to codigoPouD)
}