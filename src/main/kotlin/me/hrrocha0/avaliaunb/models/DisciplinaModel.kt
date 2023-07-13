package me.hrrocha0.avaliaunb.models

data class DisciplinaModel(
    val id: Int,
    val codigo: String,
    val nome: String,
    val descricao: String,
    val idDepartamento: Int,
) : Model {
    override fun toMap() = mapOf(
        "id" to id,
        "codigo" to codigo,
        "nome" to nome,
        "descricao" to descricao,
        "id_departamento" to idDepartamento,
    )
}