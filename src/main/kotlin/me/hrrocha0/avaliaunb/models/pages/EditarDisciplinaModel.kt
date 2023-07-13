package me.hrrocha0.avaliaunb.models.pages

import me.hrrocha0.avaliaunb.models.DepartamentoModel
import me.hrrocha0.avaliaunb.models.DisciplinaModel
import me.hrrocha0.avaliaunb.models.Model
import me.hrrocha0.avaliaunb.models.PerfilModel

data class EditarDisciplinaModel(
    val disciplinaModel: DisciplinaModel,
    val perfilModel: PerfilModel,
    val departamentosModel: List<DepartamentoModel>,
) : Model {
    override fun toMap() = mapOf(
        "disciplina" to disciplinaModel.toMap(),
        "perfil" to perfilModel.toMap(),
        "departamentos" to departamentosModel.map(DepartamentoModel::toMap)
    )
}
