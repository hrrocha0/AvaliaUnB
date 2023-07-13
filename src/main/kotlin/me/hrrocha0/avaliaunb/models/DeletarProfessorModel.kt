package me.hrrocha0.avaliaunb.models

data class DeletarProfessorModel(val professorModel: ProfessorModel, val perfilModel: PerfilModel) : Model {
    override fun toMap() = mapOf(
        "professor" to professorModel.toMap(),
        "perfil" to perfilModel.toMap(),
    )
}
