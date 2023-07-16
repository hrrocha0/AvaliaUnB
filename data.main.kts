@file:DependsOn("org.jetbrains.exposed:exposed-core:0.41.1")
@file:DependsOn("org.jetbrains.exposed:exposed-jdbc:0.41.1")
@file:DependsOn("org.xerial:sqlite-jdbc:3.30.1")

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import java.io.File

fun loadData(path: String) = File(path).readLines().drop(1)

fun insertDepartamentos(path: String) = transaction {
    loadData(path).forEach { row ->
        val (codigo, nome) = row.split(",", limit = 2)
        val sql = "INSERT INTO Departamento VALUES ($codigo, \'$nome\')"

        try {
            exec(sql)
            println("Inserted Departamento $codigo.")
        } catch (e: Exception) {
            println("Couldn't insert Departamento $codigo.")
        }
    }
    println("Inserted data from $path into Departamento.")
}

fun insertDisciplinas(path: String) = transaction {
    loadData(path).forEachIndexed { i, row ->
        val (codigo, nome, codigoDepto) = row.split(",", limit = 3)
        val codigoPouD = i + 1
        val sql = "INSERT INTO Disciplina VALUES ($codigoPouD, \'$codigo\', \'$nome\', $codigoDepto)"

        try {
            exec(sql)
            println("Inserted Disciplina $codigo.")
        } catch (e: Exception) {
            println("Couldn't insert Disciplina $codigo.")
        }
    }
    println("Inserted data from $path into Disciplina.")
}

fun insertTurmas(path: String) = transaction {
    loadData(path).forEach { row ->
        val attributes = row.split(",", limit = 9)
        val codigo = attributes[0]
        val periodo = attributes[1]
        val nomeProfessor = attributes[2]
        val horario = attributes[3]
        val vagasOcupadas = attributes[4]
        val totalVagas = attributes[5]
        val local = attributes[6]
        val codigoDisciplina = attributes[7]
        val codigoDepto = attributes[8]
        val sql = """
            INSERT INTO Turma
            VALUES ('$codigoDisciplina', $codigo, '$periodo', '$nomeProfessor', '$horario', $vagasOcupadas, $totalVagas, '$local', $codigoDepto)
        """.trimIndent()

        try {
            exec(sql)
            println("Inserted Turma $codigoDisciplina-$codigo.")
        } catch (e: Exception) {
            println("Couldn't insert Turma $codigoDisciplina-$codigo.")
        }
    }
    println("Inserted data from $path into Turma.")
}

fun insertAll(periodo: String) {
    insertDepartamentos("data/$periodo/departamentos_${periodo.replace('.', '-')}.csv")
    insertDisciplinas("data/$periodo/disciplinas_${periodo.replace('.', '-')}.csv")
    insertTurmas("data/$periodo/turmas_${periodo.replace('.', '-')}.csv")
}

val periodos = listOf("2022.1", "2022.2", "2023.1")

Database.connect("jdbc:sqlite:main.sqlite", "org.sqlite.JDBC")

for (periodo in periodos) insertAll(periodo)
