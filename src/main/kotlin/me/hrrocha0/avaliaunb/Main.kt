package me.hrrocha0.avaliaunb

import io.ktor.server.application.*
import io.ktor.server.netty.*
import me.hrrocha0.avaliaunb.plugins.configureAuthentication
import me.hrrocha0.avaliaunb.plugins.configureRouting
import me.hrrocha0.avaliaunb.plugins.configureTemplating
import org.jetbrains.exposed.sql.Database

fun main(args: Array<String>) = EngineMain.main(args)

@Suppress("UNUSED")
fun Application.main() {
    configureAuthentication()
    configureRouting()
    configureTemplating()

    Database.connect("jdbc:sqlite:main.sqlite", "org.sqlite.JDBC")
    log.info("Hello, World!")
}