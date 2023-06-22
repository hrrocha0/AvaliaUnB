plugins {
    kotlin("jvm") version "1.8.21"
    application
}

val project_group: String by project
val project_version: String by project
val ktor_version: String by project
val logback_version: String by project

group = project_group
version = project_version

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-server-freemarker:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    testImplementation(kotlin("test"))
    testImplementation("io.ktor:ktor-server-test-host:$ktor_version")
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

tasks.test {
    useJUnitPlatform()
}
