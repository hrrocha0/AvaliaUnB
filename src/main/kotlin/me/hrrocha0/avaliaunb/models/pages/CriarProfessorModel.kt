package me.hrrocha0.avaliaunb.models.pages

import me.hrrocha0.avaliaunb.models.Model
import me.hrrocha0.avaliaunb.models.PerfilModel

data class CriarProfessorModel(val perfilModel: PerfilModel): Model {
    override fun toMap() = mapOf("perfil" to perfilModel.toMap())
}
