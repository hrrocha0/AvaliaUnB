package me.hrrocha0.avaliaunb.models

import kotlin.test.Test
import kotlin.test.assertEquals

class FeedbackModelTest {
    @Test
    fun `test toMap() for Success`() {
        val model = FeedbackModel(Feedback.SUCCESS, "MESSAGE")
        val expected = mapOf("type" to "success", "message" to "MESSAGE")

        assertEquals(expected, model.toMap())
    }

    @Test
    fun `test toMap() for Error`() {
        val model = FeedbackModel(Feedback.ERROR, "MESSAGE")
        val expected = mapOf("type" to "error", "message" to "MESSAGE")

        assertEquals(expected, model.toMap())
    }
}