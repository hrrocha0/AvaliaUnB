package me.hrrocha0.avaliaunb.plugins

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import me.hrrocha0.avaliaunb.controllers.*

fun Application.configureRouting() {
    routing {
        staticResources("/static", "/static")
        route("/", IndexController)
        route("/entrar", EntrarController)
        route("/registrar", RegistrarController)
        route("/professor", ProfessorController)
    }
}

fun Route.route(path: String, controller: Controller) = controller.bindTo(createRouteFromPath(path))