package me.hrrocha0.avaliaunb.controllers

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.hrrocha0.avaliaunb.models.EntrarModel
import me.hrrocha0.avaliaunb.models.FeedbackModel
import me.hrrocha0.avaliaunb.models.Feedback
import me.hrrocha0.avaliaunb.views.EntrarView

object EntrarController : FeedbackController {
    override suspend fun ApplicationCall.respondFeedback(feedback: Feedback, message: String?) =
        respondView(EntrarView, EntrarModel(FeedbackModel(feedback, message)))

    override fun Route.routes() {
        get {
            call.respondFeedback(Feedback.SUCCESS)
        }
        authenticate("auth-form") {
            post {
                call.respondRedirect("/")
            }
        }
    }
}