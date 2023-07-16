package me.hrrocha0.avaliaunb.models

data class ProfessorOuDisciplinaModel(val codigo: Int) : Model {
    override fun toMap() = mapOf("codigo" to codigo)
}
