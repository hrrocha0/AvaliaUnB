package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.ProfessorDepartamentoModel
import java.sql.ResultSet

object ProfessorDepartamentoDAO : ReadWriteDAO<ProfessorDepartamentoModel> {
    override fun create(model: ProfessorDepartamentoModel) = try {
        val sql = """
            INSERT INTO ProfessorDepartamento
            VALUES (${model.idProfessor}, ${model.idDepartamento})
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(key: String) = try {
        val (idProfessor, idDepartamento) = key.split(",")

        val sql = """
            SELECT * FROM ProfessorDepartamento
            WHERE id_professor = $idProfessor AND id_departamento = $idDepartamento
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: ProfessorDepartamentoModel) = try {
        val professorDepartamentoModel = read("${model.idProfessor},${model.idDepartamento}")

        // Update does nothing to ProfessorDepartamento
        professorDepartamentoModel
    } catch (e: Exception) {
        null
    }

    override fun delete(key: String) = try {
        val (idProfessor, idDepartamento) = key.split(",")
        val sql = """
            DELETE FROM ProfessorDepartamento
            WHERE id_professor = $idProfessor AND id_departamento = $idDepartamento
        """.trimIndent()
        val professorDepartamento = read(key)

        executeSql(sql)
        professorDepartamento
    } catch (e: Exception) {
        null
    }

    override fun index(predicate: (ProfessorDepartamentoModel) -> Boolean) = try {
        val sql = "SELECT * FROM ProfessorDepartamento"
        executeSql(sql).filter(predicate)
    } catch (e: Exception) {
        listOf()
    }

    override fun transform(resultSet: ResultSet): ProfessorDepartamentoModel {
        val idProfessor = resultSet.getInt("id_professor")
        val idDepartamento = resultSet.getInt("id_departamento")

        return ProfessorDepartamentoModel(idProfessor, idDepartamento)
    }
}