package me.hrrocha0.avaliaunb.controllers

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.hrrocha0.avaliaunb.models.EstudanteModel
import me.hrrocha0.avaliaunb.models.FeedbackModel
import me.hrrocha0.avaliaunb.models.RegistrarModel
import me.hrrocha0.avaliaunb.models.Feedback
import me.hrrocha0.avaliaunb.models.data.EstudanteDAO
import me.hrrocha0.avaliaunb.views.RegistrarView

object RegistrarController : Controller {
    override fun Route.routes() {
        get {
            call.respondView(
                RegistrarView, RegistrarModel(
                    feedbackModel = FeedbackModel(Feedback.SUCCESS)
                )
            )
        }
        post {
            val formParameters = call.receiveParameters()
            val matricula = formParameters["matricula"]
            val nome = formParameters["nome"]
            val email = formParameters["email"]
            val senha = formParameters["senha"]
            val confirmar = formParameters["confirmar"]

            if (matricula.isNullOrBlank()
                || nome.isNullOrBlank()
                || email.isNullOrBlank()
                || senha.isNullOrBlank()
                || confirmar.isNullOrBlank()
            ) {
                call.respondView(
                    RegistrarView, RegistrarModel(
                        feedbackModel = FeedbackModel(Feedback.ERROR, "Preencha todos os campos corretamente.")
                    )
                )
                return@post
            }
            if (senha != confirmar) {
                call.respondView(
                    RegistrarView, RegistrarModel(
                        feedbackModel = FeedbackModel(Feedback.ERROR, "As senhas devem ser iguais.")
                    )
                )
                return@post
            }
            if (EstudanteDAO.read(matricula) != null) {
                call.respondView(
                    RegistrarView, RegistrarModel(
                        feedbackModel = FeedbackModel(Feedback.ERROR, "Esse usuário já existe.")
                    )
                )
                return@post
            }
            EstudanteDAO.create(
                EstudanteModel(
                    matricula = matricula,
                    nome = nome,
                    email = email,
                    senha = senha,
                    admin = false,
                    idCurso = 0,
                )
            )
            call.respondRedirect("/entrar")
        }
    }
}