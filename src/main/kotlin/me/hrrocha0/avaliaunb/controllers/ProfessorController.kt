package me.hrrocha0.avaliaunb.controllers

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.hrrocha0.avaliaunb.models.ProfessorModel
import me.hrrocha0.avaliaunb.models.ProfessorOuDisciplinaModel
import me.hrrocha0.avaliaunb.models.data.DepartamentoDAO
import me.hrrocha0.avaliaunb.models.data.PerfilDAO
import me.hrrocha0.avaliaunb.models.data.ProfessorDAO
import me.hrrocha0.avaliaunb.models.data.ProfessorOuDisciplinaDAO
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
            val perfil = PerfilDAO.read(matricula) ?: run {
                call.respondRedirect("/")
                return@get
            }
            val professores = ProfessorDAO.index()

            call.respondView(ProfessoresView, ProfessoresModel(professores, perfil))
        }
        route("/{codigo}/editar") {
            get {
                val codigoPouD = call.parameters["codigo"].toString()

                val matricula = call.verifySession {
                    call.respondRedirect("/entrar")
                    return@get
                }
                val perfil = PerfilDAO.read(matricula)?.takeIf { it.administrador } ?: run {
                    call.respondRedirect("/")
                    return@get
                }
                val professor = ProfessorDAO.read(codigoPouD) ?: run {
                    call.respondRedirect("/professor")
                    return@get
                }
                val departamentos = DepartamentoDAO.index()

                call.respondView(EditarProfessorView, EditarProfessorModel(professor, perfil, departamentos))
            }
            post {
                val codigoPouD = call.parameters["codigo"].toString()
                val formParameters = call.receiveParameters()
                val nome = formParameters["nome"]
                val codigoDepto = formParameters["codigo_depto"]?.toIntOrNull()

                if (nome.isNullOrBlank() || codigoDepto == null) {
                    call.respondRedirect("/professor/$codigoPouD/editar")
                    return@post
                }
                val professor = ProfessorDAO.read(codigoPouD) ?: run {
                    call.respondRedirect("/professor")
                    return@post
                }
                ProfessorDAO.update(
                    professor.copy(nome = nome, codigoDepto = codigoDepto),
                    codigoPouD
                )
                call.respondRedirect("/professor")
            }
        }
        route("/{codigo}/deletar") {
            get {
                val codigoPouD = call.parameters["codigo"].toString()

                val matricula = call.verifySession {
                    call.respondRedirect("/entrar")
                    return@get
                }
                val perfil = PerfilDAO.read(matricula)?.takeIf { it.administrador } ?: run {
                    call.respondRedirect("/")
                    return@get
                }
                val professor = ProfessorDAO.read(codigoPouD) ?: run {
                    call.respondRedirect("/professor")
                    return@get
                }
                call.respondView(DeletarProfessorView, DeletarProfessorModel(professor, perfil))
            }
            post {
                val codigoPouD = call.parameters["codigo"].toString()

                ProfessorDAO.delete(codigoPouD)
                call.respondRedirect("/professor")
            }
        }
        route("/criar") {
            get {
                val matricula = call.verifySession {
                    call.respondRedirect("/entrar")
                    return@get
                }
                val perfil = PerfilDAO.read(matricula)?.takeIf { it.administrador } ?: run {
                    call.respondRedirect("/")
                    return@get
                }
                val departamentos = DepartamentoDAO.index()

                call.respondView(CriarProfessorView, CriarProfessorModel(perfil, departamentos))
            }
            post {
                val formParameters = call.receiveParameters()
                val nome = formParameters["nome"]
                val codigoDepto = formParameters["codigo_depto"]?.toIntOrNull()
                val codigoPouD = ProfessorOuDisciplinaDAO.index().size + 1

                if (nome.isNullOrBlank() || codigoDepto == null) {
                    call.respondRedirect("/professor/criar")
                    return@post
                }
                ProfessorOuDisciplinaDAO.create(ProfessorOuDisciplinaModel(codigoPouD))
                ProfessorDAO.create(ProfessorModel(codigoPouD, nome, codigoDepto))
                call.respondRedirect("/professor")
            }
        }
    }
}