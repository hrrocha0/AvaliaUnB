package me.hrrocha0.avaliaunb.plugins

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import me.hrrocha0.avaliaunb.controllers.Controller
import me.hrrocha0.avaliaunb.controllers.IndexController

fun Application.configureRouting() {
    routing {
        staticResources("/static", "/static")
        route("/", IndexController)
    }
}

fun Route.route(path: String, controller: Controller) = controller.bindTo(createRouteFromPath(path))