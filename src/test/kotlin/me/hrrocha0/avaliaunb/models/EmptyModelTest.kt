package me.hrrocha0.avaliaunb.models

import kotlin.test.Test
import kotlin.test.assertEquals

class EmptyModelTest {
    @Test
    fun `test toMap()`() {
        val model = EmptyModel
        val expected = mapOf<String, Any?>()

        assertEquals(expected, model.toMap())
    }
}