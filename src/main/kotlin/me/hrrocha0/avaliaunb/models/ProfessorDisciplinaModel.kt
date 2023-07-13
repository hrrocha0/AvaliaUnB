package me.hrrocha0.avaliaunb.models

data class ProfessorDisciplinaModel(
    val idProfessor: Int,
    val idDisciplina: Int,
) : Model {
    override fun toMap() = mapOf("id_professor" to idProfessor, "id_disciplina" to idDisciplina)
}