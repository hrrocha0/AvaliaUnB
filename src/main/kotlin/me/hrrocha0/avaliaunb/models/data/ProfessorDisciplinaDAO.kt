package me.hrrocha0.avaliaunb.models.data

import java.sql.ResultSet

object ProfessorDisciplinaDAO : ReadWriteDAO<ProfessorDisciplinaModel> {
    override fun create(model: ProfessorDisciplinaModel) = try {
        val sql = """
            INSERT INTO ProfessorDisciplina
            VALUES (${model.idProfessor}, ${model.idDisciplina})
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(key: String) = try {
        val (idProfessor, idDisciplina) = key.split(",")

        val sql = """
            SELECT * FROM ProfessorDisciplina
            WHERE id_professor = $idProfessor AND id_disciplina = $idDisciplina
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: ProfessorDisciplinaModel) = try {
        val professorDisciplinaModel = read("${model.idProfessor},${model.idDisciplina}")

        // Update does nothing to ProfessorDepartamento
        professorDisciplinaModel
    } catch (e: Exception) {
        null
    }

    override fun delete(key: String) = try {
        val (idProfessor, idDisciplina) = key.split(",")
        val sql = """
            DELETE FROM ProfessorDisciplina
            WHERE id_professor = $idProfessor AND id_disciplina = $idDisciplina
        """.trimIndent()
        val professorDisciplina = read(key)

        executeSql(sql)
        professorDisciplina
    } catch (e: Exception) {
        null
    }

    override fun index(predicate: (ProfessorDisciplinaModel) -> Boolean) = try {
        val sql = "SELECT * FROM ProfessorDisciplina"
        executeSql(sql).filter(predicate)
    } catch (e: Exception) {
        listOf()
    }

    override fun transform(resultSet: ResultSet): ProfessorDisciplinaModel {
        val idProfessor = resultSet.getInt("id_professor")
        val idDisciplina = resultSet.getInt("id_disciplina")

        return ProfessorDisciplinaModel(idProfessor, idDisciplina)
    }
}