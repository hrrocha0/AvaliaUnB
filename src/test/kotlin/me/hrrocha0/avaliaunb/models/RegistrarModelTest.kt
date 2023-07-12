package me.hrrocha0.avaliaunb.models

import kotlin.test.Test
import kotlin.test.assertEquals

class RegistrarModelTest {
    @Test
    fun `test toMap()`() {
        val model = RegistrarModel(FeedbackModel(Feedback.SUCCESS, "MESSAGE"))
        val expected = mapOf("feedback" to mapOf("type" to "success", "message" to "MESSAGE"))

        assertEquals(expected, model.toMap())
    }
}