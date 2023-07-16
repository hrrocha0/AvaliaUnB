package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.ProfessorOuDisciplinaModel
import java.sql.ResultSet

object ProfessorOuDisciplinaDAO : ReadWriteDAO<ProfessorOuDisciplinaModel> {
    override fun create(model: ProfessorOuDisciplinaModel) = try {
        val sql = """
            INSERT INTO ProfessorOuDisciplina
            VALUES (${model.codigo})
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(vararg keys: String) = try {
        val sql = """
            SELECT * FROM ProfessorOuDisciplina
            WHERE id = ${keys[0]}
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: ProfessorOuDisciplinaModel, vararg keys: String) = try {
        val sql = """
            UPDATE ProfessorOuDisciplina
            SET codigo = ${model.codigo}
            WHERE codigo = ${keys[0]}
        """.trimIndent()
        val professorOuDisciplina = read(*keys)

        executeSql(sql)
        professorOuDisciplina
    } catch (e: Exception) {
        null
    }

    override fun delete(vararg keys: String) = try {
        val sql = """
            DELETE FROM ProfessorOuDisciplina
            WHERE codigo = ${keys[0]}
        """.trimIndent()
        val professorOuDisciplina = read(*keys)

        executeSql(sql)
        professorOuDisciplina
    } catch (e: Exception) {
        null
    }

    override fun index(predicate: (ProfessorOuDisciplinaModel) -> Boolean) = try {
        val sql = "SELECT * FROM ProfessorOuDisciplina"
        executeSql(sql).filter(predicate)
    } catch (e: Exception) {
        listOf()
    }

    override fun transform(resultSet: ResultSet): ProfessorOuDisciplinaModel {
        val codigo = resultSet.getInt("codigo")
        return ProfessorOuDisciplinaModel(codigo)
    }
}