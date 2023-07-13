package me.hrrocha0.avaliaunb.models

data class CriarProfessorModel(val perfilModel: PerfilModel): Model {
    override fun toMap() = mapOf("perfil" to perfilModel.toMap())
}
