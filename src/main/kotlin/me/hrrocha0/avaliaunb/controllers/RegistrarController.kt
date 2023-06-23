package me.hrrocha0.avaliaunb.controllers

import io.ktor.server.application.*
import io.ktor.server.routing.*
import me.hrrocha0.avaliaunb.models.EmptyModel
import me.hrrocha0.avaliaunb.views.RegistrarView

object RegistrarController : Controller {
    override fun Route.routes() {
        get {
            call.respondView(RegistrarView, EmptyModel)
        }
    }
}