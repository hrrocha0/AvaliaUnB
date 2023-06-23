package me.hrrocha0.avaliaunb.plugins

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import me.hrrocha0.avaliaunb.controllers.Controller
import me.hrrocha0.avaliaunb.controllers.EntrarController
import me.hrrocha0.avaliaunb.controllers.IndexController
import me.hrrocha0.avaliaunb.controllers.RegistrarController

fun Application.configureRouting() {
    routing {
        staticResources("/static", "/static")
        route("/", IndexController)
        route("/entrar", EntrarController)
        route("/registrar", RegistrarController)
    }
}

fun Route.route(path: String, controller: Controller) = controller.bindTo(createRouteFromPath(path))