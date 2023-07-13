package me.hrrocha0.avaliaunb.models.pages

import me.hrrocha0.avaliaunb.models.CursoModel
import me.hrrocha0.avaliaunb.models.FeedbackModel
import me.hrrocha0.avaliaunb.models.Model

data class RegistrarModel(val feedbackModel: FeedbackModel, val cursoModels: List<CursoModel>) : Model {
    override fun toMap() = mapOf("feedback" to feedbackModel.toMap(), "cursos" to cursoModels.map(CursoModel::toMap))
}