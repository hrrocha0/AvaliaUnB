package me.hrrocha0.avaliaunb.controllers

import io.ktor.server.application.*
import io.ktor.server.routing.*
import me.hrrocha0.avaliaunb.models.FeedbackModel
import me.hrrocha0.avaliaunb.models.RegistrarModel
import me.hrrocha0.avaliaunb.models.data.Feedback
import me.hrrocha0.avaliaunb.views.RegistrarView

object RegistrarController : FeedbackController {
    override suspend fun ApplicationCall.respondFeedback(feedback: Feedback) =
        respondView(RegistrarView, RegistrarModel(FeedbackModel(feedback)))

    override fun Route.routes() {
        get {
            call.respondFeedback(Feedback.Success())
        }
    }
}