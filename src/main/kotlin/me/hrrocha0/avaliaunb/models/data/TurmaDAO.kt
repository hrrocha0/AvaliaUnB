package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.TurmaModel
import java.sql.ResultSet

object TurmaDAO : ReadWriteDAO<TurmaModel> {
    override fun create(model: TurmaModel) = try {
        val sql = """
            INSERT INTO Turma
            VALUES (${model.idProfessor}, ${model.idDisciplina}, ${model.id}, '${model.horario}')
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(key: String) = try {
        val (idProfessor, idDisciplina, id) = key.split(",")

        val sql = """
            SELECT * FROM Turma
            WHERE id_professor = $idProfessor AND id_disciplina = $idDisciplina AND id = $id
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: TurmaModel) = try {
        val sql = """
            UPDATE Turma
            SET horario = '${model.horario}'
            WHERE id_professor = ${model.idProfessor} AND id_disciplina = ${model.idDisciplina} AND id = ${model.id} 
        """.trimIndent()
        val turma = read("${model.idProfessor},${model.idDisciplina},${model.id}")

        executeSql(sql)
        turma
    } catch (e: Exception) {
        null
    }

    override fun delete(key: String) = try {
        val (idProfessor, idDisciplina, id) = key.split(",")
        val sql = """
            DELETE FROM Turma
            WHERE id_professor = $idProfessor AND id_disciplina = $idDisciplina AND id = $id
        """.trimIndent()
        val turma = read(key)

        executeSql(sql)
        turma
    } catch (e: Exception) {
        null
    }

    override fun index(predicate: (TurmaModel) -> Boolean) = try {
        val sql = "SELECT * FROM Turma"
        executeSql(sql).filter(predicate)
    } catch (e: Exception) {
        listOf()
    }

    override fun transform(resultSet: ResultSet): TurmaModel {
        val idProfessor = resultSet.getInt("id_professor")
        val idDisciplina = resultSet.getInt("id_disciplina")
        val id = resultSet.getInt("id")
        val horario = resultSet.getString("horario")

        return TurmaModel(idProfessor, idDisciplina, id, horario)
    }
}