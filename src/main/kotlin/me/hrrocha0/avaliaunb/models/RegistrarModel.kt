package me.hrrocha0.avaliaunb.models

data class RegistrarModel(val feedbackModel: FeedbackModel, val cursoModels: List<CursoModel>) : Model {
    override fun toMap() = mapOf("feedback" to feedbackModel.toMap(), "cursos" to cursoModels.map(CursoModel::toMap))
}