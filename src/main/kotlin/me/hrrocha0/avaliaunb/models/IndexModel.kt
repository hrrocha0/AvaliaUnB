package me.hrrocha0.avaliaunb.models

data class IndexModel(val perfilModel: PerfilModel? = null) : Model {
    override fun toMap() = mapOf("perfil" to perfilModel?.toMap())
}
