package me.hrrocha0.avaliaunb.models

data object EmptyModel : Model<Nothing> {
    override fun toMap() = mapOf<String, Nothing>()
}