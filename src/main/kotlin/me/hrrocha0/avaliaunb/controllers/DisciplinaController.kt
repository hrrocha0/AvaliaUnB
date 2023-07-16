package me.hrrocha0.avaliaunb.controllers

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import me.hrrocha0.avaliaunb.models.DisciplinaModel
import me.hrrocha0.avaliaunb.models.data.DepartamentoDAO
import me.hrrocha0.avaliaunb.models.data.DisciplinaDAO
import me.hrrocha0.avaliaunb.models.data.PerfilDAO
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
            val perfil = PerfilDAO.read(matricula)

            if (perfil == null) {
                call.respondRedirect("/")
                return@get
            }
            val disciplinas = DisciplinaDAO.index()

            call.respondView(DisciplinasView, DisciplinasModel(disciplinas, perfil))
        }

        route("/{id}/editar") {
            get {
                val matricula = call.verifySession {
                    call.respondRedirect("/")
                    return@get
                }
                val perfil = PerfilDAO.read(matricula)
                val id = call.parameters["id"].toString()
                val disciplina = DisciplinaDAO.read(id)

                if (perfil == null || !perfil.admin) {
                    call.respondRedirect("/")
                    return@get
                }
                if (disciplina == null) {
                    call.respondRedirect("/disciplina")
                    return@get
                }
                val departamentos = DepartamentoDAO.index()

                call.respondView(EditarDisciplinaView, EditarDisciplinaModel(disciplina, perfil, departamentos))
            }
            post {
                val formParameters = call.receiveParameters()
                val codigo = formParameters.getOrFail("codigo")
                val nome = formParameters.getOrFail("nome")
                val descricao = formParameters.getOrFail("descricao")
                val idDepartamento = formParameters.getOrFail("id_departamento").toInt()

                val id = call.parameters["id"].toString()
                val disciplina = DisciplinaDAO.read(id)

                if (disciplina == null) {
                    call.respondRedirect("/disciplina")
                    return@post
                }
                DisciplinaDAO.update(
                    disciplina.copy(
                        codigo = codigo,
                        nome = nome,
                        descricao = descricao,
                        codigoDepto = idDepartamento
                    )
                )
                call.respondRedirect("/disciplina")
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
                val disciplina = DisciplinaDAO.read(id)

                if (perfil == null || !perfil.admin) {
                    call.respondRedirect("/")
                    return@get
                }
                if (disciplina == null) {
                    call.respondRedirect("/disciplina")
                    return@get
                }
                call.respondView(DeletarDisciplinaView, DeletarDisciplinaModel(disciplina, perfil))
            }
            post {
                val id = call.parameters["id"].toString()

                DisciplinaDAO.delete(id)
                call.respondRedirect("/disciplina")
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
                val departamentos = DepartamentoDAO.index()

                call.respondView(CriarDisciplinaView, CriarDisciplinaModel(perfil, departamentos))
            }
            post {
                val formParameters = call.receiveParameters()
                val codigo = formParameters.getOrFail("codigo")
                val nome = formParameters.getOrFail("nome")
                val descricao = formParameters.getOrFail("descricao")
                val idDepartamento = formParameters.getOrFail("id_departamento").toInt()

                if (DisciplinaDAO.index { it.codigo == codigo }.isNotEmpty()) {
                    call.respondRedirect("/disciplina")
                    return@post
                }
                val id = DisciplinaDAO.index().size + 1

                DisciplinaDAO.create(DisciplinaModel(id, codigo, nome, descricao, idDepartamento))
                call.respondRedirect("/disciplina")
            }
        }
    }
}