package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.CursoModel
import java.sql.ResultSet

object CursoDAO : ReadWriteDAO<CursoModel> {
    override fun create(model: CursoModel) = try {
        val sql = """
            INSERT INTO Curso
            VALUES (${model.id}, '${model.nome}', ${model.idDepartamento})
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(key: String) = try {
        val sql = """
            SELECT * FROM Curso
            WHERE id = $key
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: CursoModel) = try {
        val sql = """
            UPDATE Curso
            SET nome = '${model.nome},
                id_departamento = ${model.idDepartamento}
            WHERE id = ${model.id}
        """.trimIndent()
        val curso = read(model.id.toString())

        executeSql(sql)
        curso
    } catch (e: Exception) {
        null
    }

    override fun delete(key: String) = try {
        val sql = """
            DELETE FROM Curso
            WHERE id = $key
        """.trimIndent()
        val curso = read(key)

        executeSql(sql)
        curso
    } catch (e: Exception) {
        null
    }

    override fun index(predicate: (CursoModel) -> Boolean) = try {
        val sql = "SELECT * FROM Curso"
        executeSql(sql).filter(predicate)
    } catch (e: Exception) {
        listOf()
    }

    override fun transform(resultSet: ResultSet): CursoModel {
        val id = resultSet.getInt("id")
        val nome = resultSet.getString("nome")
        val idDepartamento = resultSet.getInt("id_departamento")

        return CursoModel(id, nome, idDepartamento)
    }
}