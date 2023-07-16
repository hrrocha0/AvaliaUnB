package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.ProfessorOuDisciplinaModel
import java.sql.ResultSet

object PouDDAO : ReadWriteDAO<ProfessorOuDisciplinaModel> {
    override fun create(model: ProfessorOuDisciplinaModel) = try {
        val sql = """
            INSERT INTO PouD
            VALUES (${model.codigo})
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(key: String) = try {
        val sql = """
            SELECT * FROM PouD
            WHERE id = $key
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: ProfessorOuDisciplinaModel) = try {
        val pouD = read(model.codigo.toString())

        // Update does nothing to PouD
        pouD
    } catch (e: Exception) {
        null
    }

    override fun delete(key: String) = try {
        val sql = """
            DELETE FROM PouD
            WHERE id = $key
        """.trimIndent()
        val pouD = read(key)

        executeSql(sql)
        pouD
    } catch (e: Exception) {
        null
    }

    override fun index(predicate: (ProfessorOuDisciplinaModel) -> Boolean) = try {
        val sql = "SELECT * FROM PouD"
        executeSql(sql).filter(predicate)
    } catch (e: Exception) {
        listOf()
    }

    override fun transform(resultSet: ResultSet): ProfessorOuDisciplinaModel {
        val id = resultSet.getInt("id")
        return ProfessorOuDisciplinaModel(id)
    }
}