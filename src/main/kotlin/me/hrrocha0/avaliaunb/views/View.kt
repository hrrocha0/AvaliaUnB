package me.hrrocha0.avaliaunb.views

import me.hrrocha0.avaliaunb.models.Model

interface View<in M : Model<*>> {
    fun apply(model: M): Any
}