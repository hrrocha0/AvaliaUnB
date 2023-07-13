package me.hrrocha0.avaliaunb.models

import me.hrrocha0.avaliaunb.models.pages.IndexModel
import kotlin.test.Test
import kotlin.test.assertEquals

class IndexModelTest {
    @Test
    fun `test toMap()`() {
        val model = IndexModel(
            perfilModel = PerfilModel(
                matricula = "012345678",
                nome = "Foo Bar",
                email = "foobar@aluno.unb.br",
                admin = false,
                curso = "Ciência da Computação"
            )
        )
        val expected = mapOf(
            "perfil" to mapOf(
                "matricula" to "012345678",
                "nome" to "Foo Bar",
                "email" to "foobar@aluno.unb.br",
                "admin" to false,
                "curso" to "Ciência da Computação"
            )
        )

        assertEquals(expected, model.toMap())
    }
}