package me.hrrocha0.avaliaunb.controllers

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.hrrocha0.avaliaunb.models.DisciplinaModel
import me.hrrocha0.avaliaunb.models.ProfessorOuDisciplinaModel
import me.hrrocha0.avaliaunb.models.data.DepartamentoDAO
import me.hrrocha0.avaliaunb.models.data.DisciplinaDAO
import me.hrrocha0.avaliaunb.models.data.PerfilDAO
import me.hrrocha0.avaliaunb.models.data.ProfessorOuDisciplinaDAO
import me.hrrocha0.avaliaunb.models.pages.CriarDisciplinaModel
import me.hrrocha0.avaliaunb.models.pages.DeletarDisciplinaModel
import me.hrrocha0.avaliaunb.models.pages.DisciplinasModel
import me.hrrocha0.avaliaunb.models.pages.EditarDisciplinaModel
import me.hrrocha0.avaliaunb.plugins.verifySession
import me.hrrocha0.avaliaunb.views.CriarDisciplinaView
import me.hrrocha0.avaliaunb.views.DeletarDisciplinaView
import me.hrrocha0.avaliaunb.views.DisciplinasView
import me.hrrocha0.avaliaunb.views.EditarDisciplinaView

object DisciplinaController : Controller {
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
            val disciplinas = DisciplinaDAO.index()

            call.respondView(DisciplinasView, DisciplinasModel(disciplinas, perfil))
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
                val disciplina = DisciplinaDAO.read(codigoPouD) ?: run {
                    call.respondRedirect("/disciplina")
                    return@get
                }
                val departamentos = DepartamentoDAO.index()

                call.respondView(EditarDisciplinaView, EditarDisciplinaModel(disciplina, perfil, departamentos))
            }
            post {
                val codigoPouD = call.parameters["codigo"].toString()
                val formParameters = call.receiveParameters()
                val codigo = formParameters["codigo"]
                val nome = formParameters["nome"]
                val codigoDepto = formParameters["codigo_depto"]?.toIntOrNull()

                if (codigo.isNullOrBlank() || nome.isNullOrBlank() || codigoDepto == null) {
                    call.respondRedirect("/disciplina/$codigoPouD/editar")
                    return@post
                }
                val disciplina = DisciplinaDAO.read(codigoPouD) ?: run {
                    call.respondRedirect("/disciplina")
                    return@post
                }
                DisciplinaDAO.update(
                    disciplina.copy(codigo = codigo, nome = nome, codigoDepto = codigoDepto),
                    codigoPouD
                )
                call.respondRedirect("/disciplina")
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
                val disciplina = DisciplinaDAO.read(codigoPouD) ?: run {
                    call.respondRedirect("/disciplina")
                    return@get
                }
                call.respondView(DeletarDisciplinaView, DeletarDisciplinaModel(disciplina, perfil))
            }
            post {
                val codigoPouD = call.parameters["codigo"].toString()

                DisciplinaDAO.delete(codigoPouD)
                call.respondRedirect("/disciplina")
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

                call.respondView(CriarDisciplinaView, CriarDisciplinaModel(perfil, departamentos))
            }
            post {
                val formParameters = call.receiveParameters()
                val codigo = formParameters["codigo"]
                val nome = formParameters["nome"]
                val codigoDepto = formParameters["codigo_depto"]?.toIntOrNull()
                val codigoPouD = ProfessorOuDisciplinaDAO.index().size + 1

                if (codigo.isNullOrBlank() || nome.isNullOrBlank() || codigoDepto == null) {
                    call.respondRedirect("/disciplina/criar")
                    return@post
                }
                ProfessorOuDisciplinaDAO.create(ProfessorOuDisciplinaModel(codigoPouD))
                DisciplinaDAO.create(DisciplinaModel(codigoPouD, codigo, nome, codigoDepto))
                call.respondRedirect("/disciplina")
            }
        }
    }
}