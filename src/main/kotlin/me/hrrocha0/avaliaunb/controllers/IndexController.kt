package me.hrrocha0.avaliaunb.controllers

import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import me.hrrocha0.avaliaunb.models.pages.IndexModel
import me.hrrocha0.avaliaunb.models.data.PerfilDAO
import me.hrrocha0.avaliaunb.plugins.UserSession
import me.hrrocha0.avaliaunb.views.IndexView

object IndexController : Controller {
    override fun Route.routes() {
        get {
            val matricula = call.sessions.get<UserSession>()?.name

            if (matricula != null) {
                val perfil = PerfilDAO.read(matricula)
                call.respondView(IndexView, IndexModel(perfil))

                return@get
            }
            call.respondView(IndexView, IndexModel())
        }
    }
}