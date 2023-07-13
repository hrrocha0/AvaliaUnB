package me.hrrocha0.avaliaunb.models.pages

import me.hrrocha0.avaliaunb.models.DepartamentoModel
import me.hrrocha0.avaliaunb.models.Model
import me.hrrocha0.avaliaunb.models.PerfilModel

data class CriarDisciplinaModel(val perfilModel: PerfilModel, val departamentoModels: List<DepartamentoModel>) : Model {
    override fun toMap() = mapOf(
        "perfil" to perfilModel.toMap(),
        "departamentos" to departamentoModels.map(DepartamentoModel::toMap),
    )
}