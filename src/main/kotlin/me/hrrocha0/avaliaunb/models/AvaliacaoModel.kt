package me.hrrocha0.avaliaunb.models

data class AvaliacaoModel(
    val idPouD: Int,
    val id: Int,
    val nota: Int,
    val comentario: String,
    val matriculaEstudante: String
) : Model {
    override fun toMap() = mapOf(
        "id_p_ou_d" to idPouD,
        "id" to id,
        "nota" to nota,
        "comentario" to comentario,
        "matricula_estudante" to matriculaEstudante,
    )
}
