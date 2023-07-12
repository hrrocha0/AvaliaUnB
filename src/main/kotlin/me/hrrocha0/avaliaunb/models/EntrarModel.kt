package me.hrrocha0.avaliaunb.models

data class EntrarModel(val feedbackModel: FeedbackModel) : Model {
    override fun toMap() = mapOf("feedback" to feedbackModel.toMap())
}