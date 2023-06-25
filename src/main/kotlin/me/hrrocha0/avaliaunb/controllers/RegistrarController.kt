package me.hrrocha0.avaliaunb.controllers

import io.ktor.server.application.*
import io.ktor.server.routing.*
import me.hrrocha0.avaliaunb.models.FeedbackModel
import me.hrrocha0.avaliaunb.models.RegistrarModel
import me.hrrocha0.avaliaunb.models.data.Feedback
import me.hrrocha0.avaliaunb.views.RegistrarView

object RegistrarController : Controller {
    override fun Route.routes() {
        get {
            call.respondView(RegistrarView, RegistrarModel(FeedbackModel(Feedback.Success())))
        }
    }
}