package me.hrrocha0.avaliaunb.models

data class DisciplinaModel(
    val codigoPouD: Int,
    val codigo: String,
    val nome: String,
    val codigoDepto: Int
) : Model {
    override fun toMap() = mapOf(
        "codigo_p_ou_d" to codigoPouD,
        "codigo" to codigo,
        "nome" to nome,
        "codigo_depto" to codigoDepto,
    )
}