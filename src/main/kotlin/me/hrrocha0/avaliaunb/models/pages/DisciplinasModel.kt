package me.hrrocha0.avaliaunb.models.pages

import me.hrrocha0.avaliaunb.models.DisciplinaModel
import me.hrrocha0.avaliaunb.models.Model
import me.hrrocha0.avaliaunb.models.PerfilModel

data class DisciplinasModel(val disciplinaModels: List<DisciplinaModel>, val perfilModel: PerfilModel) : Model {
    override fun toMap() = mapOf(
        "disciplinas" to disciplinaModels.map(DisciplinaModel::toMap),
        "perfil" to perfilModel.toMap()
    )
}