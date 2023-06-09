plugins {
    kotlin("jvm") version "1.9.0"
    id("io.ktor.plugin") version "2.3.2"
    application
}

val project_group: String by project
val project_version: String by project
val ktor_version: String by project
val exposed_version: String by project
val sqlite_jdbc_version: String by project
val logback_version: String by project

group = project_group
version = project_version

repositories {
    mavenCentral()
}

dependencies {
    // Ktor dependencies
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-server-freemarker:$ktor_version")
    implementation("io.ktor:ktor-server-auth:$ktor_version")
    implementation("io.ktor:ktor-server-sessions:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    // Exposed/SQLite dependencies
    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
    implementation("org.xerial:sqlite-jdbc:$sqlite_jdbc_version")
    // Test dependencies
    testImplementation(kotlin("test"))
    testImplementation("io.ktor:ktor-server-test-host:$ktor_version")
}

application {
    mainClass = "io.ktor.server.netty.EngineMain"
}

ktor {
    fatJar {
        archiveFileName = "AvaliaUnB-${project_version}.jar"
    }
}

tasks.test {
    useJUnitPlatform()
}
