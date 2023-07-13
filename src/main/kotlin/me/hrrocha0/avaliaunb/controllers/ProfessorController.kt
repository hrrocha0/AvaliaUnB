package me.hrrocha0.avaliaunb.controllers

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import me.hrrocha0.avaliaunb.models.*
import me.hrrocha0.avaliaunb.models.data.PerfilDAO
import me.hrrocha0.avaliaunb.models.data.ProfessorDAO
import me.hrrocha0.avaliaunb.models.pages.CriarProfessorModel
import me.hrrocha0.avaliaunb.models.pages.DeletarProfessorModel
import me.hrrocha0.avaliaunb.models.pages.EditarProfessorModel
import me.hrrocha0.avaliaunb.models.pages.ProfessoresModel
import me.hrrocha0.avaliaunb.plugins.verifySession
import me.hrrocha0.avaliaunb.views.CriarProfessorView
import me.hrrocha0.avaliaunb.views.DeletarProfessorView
import me.hrrocha0.avaliaunb.views.EditarProfessorView
import me.hrrocha0.avaliaunb.views.ProfessoresView

object ProfessorController : Controller {
    override fun Route.routes() {
        get {
            val matricula = call.verifySession {
                call.respondRedirect("/entrar")
                return@get
            }
            val perfil = PerfilDAO.read(matricula)

            if (perfil == null || !perfil.admin) {
                call.respondRedirect("/")
                return@get
            }
            val professores = ProfessorDAO.index()

            call.respondView(ProfessoresView, ProfessoresModel(professores, perfil))
        }

        route("/{id}/editar") {
            get {
                val matricula = call.verifySession {
                    call.respondRedirect("/")
                    return@get
                }
                val perfil = PerfilDAO.read(matricula)
                val id = call.parameters["id"].toString()
                val professor = ProfessorDAO.read(id)

                if (perfil == null || !perfil.admin) {
                    call.respondRedirect("/")
                    return@get
                }
                if (professor == null) {
                    call.respondRedirect("/professor")
                    return@get
                }
                call.respondView(EditarProfessorView, EditarProfessorModel(professor, perfil))
            }
            post {
                val formParameters = call.receiveParameters()
                val matricula = formParameters.getOrFail("matricula")
                val nome = formParameters.getOrFail("nome")
                val email = formParameters.getOrFail("email")

                val id = call.parameters["id"].toString()
                val professor = ProfessorDAO.read(id)

                if (professor == null) {
                    call.respondRedirect("/professor")
                    return@post
                }
                ProfessorDAO.update(professor.copy(matricula = matricula, nome = nome, email = email))
                call.respondRedirect("/professor")
            }
        }
        route("/{id}/deletar") {
            get {
                val matricula = call.verifySession {
                    call.respondRedirect("/entrar")
                    return@get
                }
                val id = call.parameters["id"].toString()

                val perfil = PerfilDAO.read(matricula)
                val professor = ProfessorDAO.read(id)

                if (perfil == null || !perfil.admin) {
                    call.respondRedirect("/")
                    return@get
                }
                if (professor == null) {
                    call.respondRedirect("/professor")
                    return@get
                }
                call.respondView(DeletarProfessorView, DeletarProfessorModel(professor, perfil))
            }
            post {
                val id = call.parameters["id"].toString()

                ProfessorDAO.delete(id)
                call.respondRedirect("/professor")
            }
        }
        route("/criar") {
            get {
                val matricula = call.verifySession {
                    call.respondRedirect("/entrar")
                    return@get
                }
                val perfil = PerfilDAO.read(matricula)

                if (perfil == null || !perfil.admin) {
                    call.respondRedirect("/")
                    return@get
                }
                call.respondView(CriarProfessorView, CriarProfessorModel(perfil))
            }
            post {
                val formParameters = call.receiveParameters()
                val matricula = formParameters.getOrFail("matricula")
                val nome = formParameters.getOrFail("nome")
                val email = formParameters.getOrFail("email")

                if (ProfessorDAO.read(matricula) != null) {
                    call.respondRedirect("/professor")
                    return@post
                }
                val id = ProfessorDAO.index().size + 1

                ProfessorDAO.create(ProfessorModel(id, matricula, nome, email))
                call.respondRedirect("/professor")
            }
        }
    }
}