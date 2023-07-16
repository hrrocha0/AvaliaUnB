package me.hrrocha0.avaliaunb.models.pages

import me.hrrocha0.avaliaunb.models.DepartamentoModel
import me.hrrocha0.avaliaunb.models.Model
import me.hrrocha0.avaliaunb.models.PerfilModel
import me.hrrocha0.avaliaunb.models.ProfessorModel

data class EditarProfessorModel(
    val professorModel: ProfessorModel,
    val perfilModel: PerfilModel,
    val departamentoModels: List<DepartamentoModel>,
) : Model {
    override fun toMap() = mapOf(
        "professor" to professorModel.toMap(),
        "perfil" to perfilModel.toMap(),
        "departamentos" to departamentoModels.map(DepartamentoModel::toMap),
    )
}
