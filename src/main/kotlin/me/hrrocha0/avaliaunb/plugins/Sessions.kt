package me.hrrocha0.avaliaunb.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.sessions.*

fun Application.configureSessions() {
    install(Sessions) {
        cookie<UserSession>("user_session") {
            cookie.path = "/"
            cookie.maxAgeInSeconds = 60
        }
    }
}

inline fun ApplicationCall.verifySession(challenge: () -> Unit): String {
    val matricula = sessions.get<UserSession>()?.name
    if (matricula == null) challenge()

    return matricula!!
}

data class UserSession(val name: String, val count: Int) : Principal