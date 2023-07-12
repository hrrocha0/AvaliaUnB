package me.hrrocha0.avaliaunb.models

data class FeedbackModel(val feedback: Feedback, val message: String? = null) : Model {
    override fun toMap() = mapOf("type" to feedback.type, "message" to message)
}