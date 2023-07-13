package me.hrrocha0.avaliaunb.models

data class EditarProfessorModel(val professorModel: ProfessorModel, val perfilModel: PerfilModel) : Model {
    override fun toMap() = mapOf(
        "professor" to professorModel.toMap(),
        "perfil" to perfilModel.toMap(),
    )
}
