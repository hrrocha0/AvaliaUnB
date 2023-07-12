package me.hrrocha0.avaliaunb.models

data object EmptyModel : Model {
    override fun toMap() = mapOf<String, Any?>()
}