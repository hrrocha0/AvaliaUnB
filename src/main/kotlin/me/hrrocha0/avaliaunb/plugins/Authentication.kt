package me.hrrocha0.avaliaunb.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*

fun Application.configureAuthentication() {
    install(Authentication) {
        form("auth-form") {
            userParamName = "matricula"
            passwordParamName = "senha"

            validate { credentials ->
                if (credentials.name == "admin" && credentials.password == "1234") {
                    UserIdPrincipal(credentials.name)
                } else null
            }
            challenge("/entrar")
        }
    }
}