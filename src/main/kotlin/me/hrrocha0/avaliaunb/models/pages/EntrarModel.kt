package me.hrrocha0.avaliaunb.models.pages

import me.hrrocha0.avaliaunb.models.FeedbackModel
import me.hrrocha0.avaliaunb.models.Model

data class EntrarModel(val feedbackModel: FeedbackModel) : Model {
    override fun toMap() = mapOf("feedback" to feedbackModel.toMap())
}