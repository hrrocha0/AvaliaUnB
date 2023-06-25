package me.hrrocha0.avaliaunb.models

data class RegistrarModel(val feedbackModel: FeedbackModel) : Model<Any?> {
    override fun toMap() = mapOf("feedback" to feedbackModel.toMap())
}