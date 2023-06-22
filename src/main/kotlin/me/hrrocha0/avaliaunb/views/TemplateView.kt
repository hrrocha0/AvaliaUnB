package me.hrrocha0.avaliaunb.views

import io.ktor.server.freemarker.*
import me.hrrocha0.avaliaunb.models.Model

abstract class TemplateView<in M : Model<*>>(private val template: String) : View<M> {
    override fun apply(model: M) = FreeMarkerContent(template, model.toMap())
}