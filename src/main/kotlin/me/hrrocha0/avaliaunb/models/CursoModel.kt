package me.hrrocha0.avaliaunb.models

data class CursoModel(
    val codigo: Int,
    val nome: String,
    val codigoDepto: Int,
) : Model {
    override fun toMap() = mapOf("codigo" to codigo, "nome" to nome, "codigo_depto" to codigoDepto)
}