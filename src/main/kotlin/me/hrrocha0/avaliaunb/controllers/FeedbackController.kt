package me.hrrocha0.avaliaunb.controllers

import io.ktor.server.application.*
import me.hrrocha0.avaliaunb.models.data.Feedback

interface FeedbackController : Controller {
    suspend fun ApplicationCall.respondFeedback(feedback: Feedback)
}