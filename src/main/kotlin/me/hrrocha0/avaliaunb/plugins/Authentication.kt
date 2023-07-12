package me.hrrocha0.avaliaunb.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
import me.hrrocha0.avaliaunb.controllers.EntrarController
import me.hrrocha0.avaliaunb.models.EntrarModel
import me.hrrocha0.avaliaunb.models.Feedback
import me.hrrocha0.avaliaunb.models.FeedbackModel
import me.hrrocha0.avaliaunb.models.data.EstudanteDAO
import me.hrrocha0.avaliaunb.views.EntrarView

fun Application.configureAuthentication() {
    install(Authentication) {
        form("auth-form") {
            userParamName = "matricula"
            passwordParamName = "senha"

            validate { credentials ->
                val estudante = EstudanteDAO.read(credentials.name)

                if (estudante != null && credentials.password == estudante.senha) {
                    UserIdPrincipal(credentials.name)
                } else null
            }
            challenge { credentials ->
                with(EntrarController) {
                    if (credentials == null || credentials.name.isBlank() || credentials.password.isBlank()) {
                        call.respondView(
                            view = EntrarView,
                            model = EntrarModel(FeedbackModel(Feedback.ERROR, "Preencha todos os campos corretamente."))
                        )
                        return@challenge
                    }
                    call.respondView(
                        view = EntrarView,
                        model = EntrarModel(FeedbackModel(Feedback.ERROR, "Usuário e/ou senha incorreto(s)."))
                    )
                }
            }
        }
    }
}