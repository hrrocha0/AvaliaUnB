package me.hrrocha0.avaliaunb.plugins

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import me.hrrocha0.avaliaunb.controllers.Controller

fun Application.configureRouting() {
    routing {
        staticResources("/static", "/static")
    }
}

fun Route.route(path: String, controller: Controller) = controller.bindTo(createRouteFromPath(path))