package me.hrrocha0.avaliaunb.controllers

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.hrrocha0.avaliaunb.models.Model
import me.hrrocha0.avaliaunb.views.View

interface Controller {
    fun Route.routes()
    fun bindTo(route: Route) = route.routes()

    suspend fun <M : Model> ApplicationCall.respondView(view: View<M>, model: M) = respond(view.apply(model))
}