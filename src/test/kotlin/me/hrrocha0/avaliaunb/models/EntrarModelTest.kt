package me.hrrocha0.avaliaunb.models

import me.hrrocha0.avaliaunb.models.pages.EntrarModel
import kotlin.test.Test
import kotlin.test.assertEquals

class EntrarModelTest {
    @Test
    fun `test toMap()`() {
        val model = EntrarModel(FeedbackModel(Feedback.SUCCESS, "MESSAGE"))
        val expected = mapOf("feedback" to mapOf("type" to "success", "message" to "MESSAGE"))

        assertEquals(expected, model.toMap())
    }
}