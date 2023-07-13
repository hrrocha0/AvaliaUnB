package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.ProfessorModel
import java.sql.ResultSet

object ProfessorDAO : ReadWriteDAO<ProfessorModel> {
    override fun create(model: ProfessorModel) = try {
        val sql = """
            INSERT INTO Professor
            VALUES (${model.id}, '${model.matricula}', '${model.nome}', '${model.email}')
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(key: String) = try {
        val sql = """
            SELECT * FROM Professor
            WHERE id = $key
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: ProfessorModel) = try {
        val sql = """
            UPDATE Professor
            SET matricula = '${model.matricula}',
                nome = '${model.nome}',
                email = '${model.email}'
            WHERE id = ${model.id} 
        """.trimIndent()
        val professor = read(model.id.toString())

        executeSql(sql)
        professor
    } catch (e: Exception) {
        null
    }

    override fun delete(key: String) = try {
        val sql = """
            DELETE FROM Professor
            WHERE id = $key
        """.trimIndent()
        val professor = read(key)

        executeSql(sql)
        professor
    } catch (e: Exception) {
        null
    }

    override fun index(predicate: (ProfessorModel) -> Boolean) = try {
        val sql = "SELECT * FROM Professor"
        executeSql(sql).filter(predicate)
    } catch (e: Exception) {
        listOf()
    }

    override fun transform(resultSet: ResultSet): ProfessorModel {
        val id = resultSet.getInt("id")
        val matricula = resultSet.getString("matricula")
        val nome = resultSet.getString("nome")
        val email = resultSet.getString("email")

        return ProfessorModel(id, matricula, nome, email)
    }
}