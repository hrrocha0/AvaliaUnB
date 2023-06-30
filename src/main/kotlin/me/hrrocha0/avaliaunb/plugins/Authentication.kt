package me.hrrocha0.avaliaunb.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
import me.hrrocha0.avaliaunb.controllers.EntrarController
import me.hrrocha0.avaliaunb.models.data.Feedback

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
            challenge { credentials ->
                with(EntrarController) {
                    if (credentials == null || credentials.name.isBlank() || credentials.password.isBlank()) {
                        call.respondFeedback(Feedback.Error("Preencha todos os campos corretamente."))
                        return@challenge
                    }
                    call.respondFeedback(Feedback.Error("Usuário e/ou senha incorreto(s)."))
                }
            }
        }
    }
}