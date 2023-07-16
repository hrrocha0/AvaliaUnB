package me.hrrocha0.avaliaunb.models

data class DisciplinaModel(
    val codigo: String,
    val nome: String,
    val codigoDepto: Int,
    val codigoPouD: Int,
) : Model {
    override fun toMap() = mapOf(
        "codigo" to codigo,
        "nome" to nome,
        "codigo_depto" to codigoDepto,
        "codigo_p_ou_d" to codigoPouD,
    )
}