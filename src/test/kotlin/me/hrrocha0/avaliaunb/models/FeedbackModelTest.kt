package me.hrrocha0.avaliaunb.models

import me.hrrocha0.avaliaunb.models.data.Feedback
import kotlin.test.Test
import kotlin.test.assertEquals

class FeedbackModelTest {
    @Test
    fun `test toMap() for Success`() {
        val model = FeedbackModel(Feedback.Success("MESSAGE"))
        val expected = mapOf("type" to "success", "message" to "MESSAGE")

        assertEquals(expected, model.toMap())
    }

    @Test
    fun `test toMap() for Error`() {
        val model = FeedbackModel(Feedback.Error("MESSAGE"))
        val expected = mapOf("type" to "error", "message" to "MESSAGE")

        assertEquals(expected, model.toMap())
    }
}