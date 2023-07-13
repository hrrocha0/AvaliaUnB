package me.hrrocha0.avaliaunb.models

import me.hrrocha0.avaliaunb.models.pages.RegistrarModel
import kotlin.test.Test
import kotlin.test.assertEquals

class RegistrarModelTest {
    @Test
    fun `test toMap()`() {
        val model = RegistrarModel(
            feedbackModel = FeedbackModel(Feedback.SUCCESS, "MESSAGE"),
            cursoModels = listOf(CursoModel(1, "Ciência da Computação", 1))
        )
        val expected = mapOf(
            "feedback" to mapOf("type" to "success", "message" to "MESSAGE"),
            "cursos" to listOf(mapOf("id" to 1, "nome" to "Ciência da Computação", "id_departamento" to 1))
        )

        assertEquals(expected, model.toMap())
    }
}