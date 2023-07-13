package me.hrrocha0.avaliaunb.controllers

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.hrrocha0.avaliaunb.models.EstudanteModel
import me.hrrocha0.avaliaunb.models.FeedbackModel
import me.hrrocha0.avaliaunb.models.pages.RegistrarModel
import me.hrrocha0.avaliaunb.models.Feedback
import me.hrrocha0.avaliaunb.models.data.CursoDAO
import me.hrrocha0.avaliaunb.models.data.EstudanteDAO
import me.hrrocha0.avaliaunb.views.RegistrarView

object RegistrarController : Controller {
    override fun Route.routes() {
        get {
            call.respondView(
                RegistrarView, RegistrarModel(
                    feedbackModel = FeedbackModel(Feedback.SUCCESS),
                    cursoModels = CursoDAO.index()
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
            val idCurso = formParameters["curso"]?.toIntOrNull()
            val cursoModels = CursoDAO.index()

            if (matricula.isNullOrBlank()
                || nome.isNullOrBlank()
                || email.isNullOrBlank()
                || senha.isNullOrBlank()
                || confirmar.isNullOrBlank()
                || idCurso == null
            ) {
                call.respondView(
                    RegistrarView, RegistrarModel(
                        feedbackModel = FeedbackModel(Feedback.ERROR, "Preencha todos os campos corretamente."),
                        cursoModels = cursoModels,
                    )
                )
                return@post
            }
            if (senha != confirmar) {
                call.respondView(
                    RegistrarView, RegistrarModel(
                        feedbackModel = FeedbackModel(Feedback.ERROR, "As senhas devem ser iguais."),
                        cursoModels = cursoModels,
                    )
                )
                return@post
            }
            if (EstudanteDAO.read(matricula) != null) {
                call.respondView(
                    RegistrarView, RegistrarModel(
                        feedbackModel = FeedbackModel(Feedback.ERROR, "Esse usuário já existe."),
                        cursoModels = cursoModels,
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
                    idCurso = idCurso,
                )
            )
            call.respondRedirect("/entrar")
        }
    }
}