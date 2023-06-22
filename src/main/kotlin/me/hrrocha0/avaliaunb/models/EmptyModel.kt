package me.hrrocha0.avaliaunb.models

object EmptyModel : Model<Nothing> {
    override fun toMap() = mapOf<String, Nothing>()
    override fun toString() = "EmptyModel"
}