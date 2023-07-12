package me.hrrocha0.avaliaunb.models

import kotlin.test.Test
import kotlin.test.assertEquals

class PerfilModelTest {
    @Test
    fun `test toMap()`() {
        val model = PerfilModel(
            matricula = "012345678",
            nome = "Foo Bar",
            email = "foobar@aluno.unb.br",
            admin = false,
            curso = "Ciência da Computação"
        )
        val expected = mapOf(
            "matricula" to "012345678",
            "nome" to "Foo Bar",
            "email" to "foobar@aluno.unb.br",
            "admin" to false,
            "curso" to "Ciência da Computação"
        )

        assertEquals(expected, model.toMap())
    }
}