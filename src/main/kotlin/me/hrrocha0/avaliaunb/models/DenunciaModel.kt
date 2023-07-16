package me.hrrocha0.avaliaunb.models

data class DenunciaModel(
    val codigoPouD: Int,
    val codigoAvaliacao: Int,
    val codigo: Int,
    val comentario: String,
    val matriculaEstudante: String,
    val matriculaAdministrador: String,
) : Model {
    override fun toMap() = mapOf(
        "codigo_p_ou_d" to codigoPouD,
        "codigo_avaliacao" to codigoAvaliacao,
        "codigo" to codigo,
        "comentario" to comentario,
        "matricula_estudante" to matriculaEstudante,
        "matricula_administrador" to matriculaAdministrador,
    )
}