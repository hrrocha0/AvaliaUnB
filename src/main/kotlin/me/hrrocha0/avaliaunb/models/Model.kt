package me.hrrocha0.avaliaunb.models

interface Model<out T> {
    fun toMap(): Map<String, T>
}