package me.hrrocha0.avaliaunb.models

data class CursoModel(
    val id: Int,
    val nome: String,
    val idDepartamento: Int,
) : Model {
    override fun toMap() = mapOf("id" to id, "nome" to nome, "id_departamento" to idDepartamento)
}