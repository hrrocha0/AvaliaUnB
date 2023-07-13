package me.hrrocha0.avaliaunb.models.pages

import me.hrrocha0.avaliaunb.models.Model
import me.hrrocha0.avaliaunb.models.PerfilModel
import me.hrrocha0.avaliaunb.models.ProfessorModel

data class DeletarProfessorModel(val professorModel: ProfessorModel, val perfilModel: PerfilModel) : Model {
    override fun toMap() = mapOf(
        "professor" to professorModel.toMap(),
        "perfil" to perfilModel.toMap(),
    )
}
