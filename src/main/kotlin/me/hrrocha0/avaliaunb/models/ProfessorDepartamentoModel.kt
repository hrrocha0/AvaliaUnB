package me.hrrocha0.avaliaunb.models

data class ProfessorDepartamentoModel(
    val idProfessor: Int,
    val idDepartamento: Int,
) : Model {
    override fun toMap() = mapOf("id_professor" to idProfessor, "id_departamento" to idDepartamento)
}