package me.hrrocha0.avaliaunb.models

data class ProfessoresModel(val professorModels: List<ProfessorModel>, val perfilModel: PerfilModel) : Model {
    override fun toMap() = mapOf(
        "professores" to professorModels.map(ProfessorModel::toMap),
        "perfil" to perfilModel.toMap()
    )
}