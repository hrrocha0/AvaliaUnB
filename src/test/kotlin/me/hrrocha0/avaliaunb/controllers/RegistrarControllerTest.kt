package me.hrrocha0.avaliaunb.controllers

import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class RegistrarControllerTest {
    @Test
    fun `test GET`() = testApplication {
        val response = client.get("/registrar")
        val expectedContentType = ContentType.Text.Html.withParameter("charset", "UTF-8")

        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals(expectedContentType, response.contentType())
    }
}