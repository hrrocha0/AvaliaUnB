package me.hrrocha0.avaliaunb.models

data class ProfessorModel(
    val codigoPouD: Int,
    val nome: String,
    val codigoDepto: Int,
) : Model {
    override fun toMap() = mapOf("codigo_p_ou_d" to codigoPouD, "nome" to nome, "codigo_depto" to codigoDepto)
}