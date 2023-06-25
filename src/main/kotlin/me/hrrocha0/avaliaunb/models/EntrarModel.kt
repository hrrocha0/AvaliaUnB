package me.hrrocha0.avaliaunb.models

data class EntrarModel(val feedbackModel: FeedbackModel) : Model<Any?> {
    override fun toMap() = mapOf("feedback" to feedbackModel.toMap())
}