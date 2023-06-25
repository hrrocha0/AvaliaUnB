package me.hrrocha0.avaliaunb.models

import me.hrrocha0.avaliaunb.models.data.Feedback

data class FeedbackModel(val feedback: Feedback) : Model<String?> {
    override fun toMap() = mapOf("type" to feedback.type, "message" to feedback.message)
}