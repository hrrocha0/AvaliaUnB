package me.hrrocha0.avaliaunb.models.pages

import me.hrrocha0.avaliaunb.models.Model
import me.hrrocha0.avaliaunb.models.PerfilModel
import me.hrrocha0.avaliaunb.models.ProfessorModel

data class ProfessoresModel(val professorModels: List<ProfessorModel>, val perfilModel: PerfilModel) : Model {
    override fun toMap() = mapOf(
        "professores" to professorModels.map(ProfessorModel::toMap),
        "perfil" to perfilModel.toMap()
    )
}