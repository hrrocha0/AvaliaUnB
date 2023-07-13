package me.hrrocha0.avaliaunb.models.pages

import me.hrrocha0.avaliaunb.models.DisciplinaModel
import me.hrrocha0.avaliaunb.models.Model
import me.hrrocha0.avaliaunb.models.PerfilModel

data class DeletarDisciplinaModel(val disciplinaModel: DisciplinaModel, val perfilModel: PerfilModel) : Model {
    override fun toMap() = mapOf(
        "disciplina" to disciplinaModel.toMap(),
        "perfil" to perfilModel.toMap(),
    )
}
