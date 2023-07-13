package me.hrrocha0.avaliaunb.models

data class DenunciaModel(
    val idPouD: Int,
    val idAvaliacao: Int,
    val id: Int,
    val comentario: String,
    val matriculaEstudante: String,
    val matriculaAvaliador: String,
) : Model {
    override fun toMap() = mapOf(
        "id_p_ou_d" to idPouD,
        "id_avaliacao" to idAvaliacao,
        "id" to id,
        "comentario" to comentario,
        "matricula_estudante" to matriculaEstudante,
        "matricula_avaliador" to matriculaAvaliador,
    )
}