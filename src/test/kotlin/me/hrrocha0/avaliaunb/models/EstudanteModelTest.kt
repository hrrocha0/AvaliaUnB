package me.hrrocha0.avaliaunb.models

import kotlin.test.Test
import kotlin.test.assertEquals

class EstudanteModelTest {
    @Test
    fun `test toMap()`() {
        val model = EstudanteModel(
            matricula = "012345678",
            nome = "Foo Bar",
            email = "foobar@aluno.unb.br",
            senha = "abc1234",
            admin = false,
            idCurso = 0,
        )
        val expected = mapOf(
            "matricula" to "012345678",
            "nome" to "Foo Bar",
            "email" to "foobar@aluno.unb.br",
            "senha" to "abc1234",
            "admin" to false,
            "id_curso" to 0,
        )

        assertEquals(expected, model.toMap())
    }
}