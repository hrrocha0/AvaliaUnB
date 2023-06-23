package me.hrrocha0.avaliaunb.controllers

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.hrrocha0.avaliaunb.models.EmptyModel
import me.hrrocha0.avaliaunb.views.EntrarView

object EntrarController : Controller {
    override fun Route.routes() {
        get {
            call.respondView(EntrarView, EmptyModel)
        }
        authenticate("auth-form") {
            post {
                call.respondRedirect("/")
            }
        }
    }
}