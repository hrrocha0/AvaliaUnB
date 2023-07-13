package me.hrrocha0.avaliaunb.models

data class PouDModel(val id: Int) : Model {
    override fun toMap() = mapOf("id" to id)
}
