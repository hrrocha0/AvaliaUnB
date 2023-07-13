package me.hrrocha0.avaliaunb.models

data class TurmaModel(
    val idProfessor: Int,
    val idDisciplina: Int,
    val id: Int,
    val horario: String,
) : Model {
    override fun toMap() = mapOf(
        "id_professor" to idProfessor,
        "id_disciplina" to idDisciplina,
        "id" to id,
        "horario" to horario,
    )
}