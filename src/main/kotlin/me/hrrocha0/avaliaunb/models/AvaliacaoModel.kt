package me.hrrocha0.avaliaunb.models

data class AvaliacaoModel(
    val codigoPouD: Int,
    val codigo: Int,
    val nota: Int,
    val comentario: String,
    val matriculaEstudante: String
) : Model {
    override fun toMap() = mapOf(
        "codigo_p_ou_d" to codigoPouD,
        "codigo" to codigo,
        "nota" to nota,
        "comentario" to comentario,
        "matricula_estudante" to matriculaEstudante,
    )
}
