package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.CursoModel
import java.sql.ResultSet

object CursoDAO : ReadWriteDAO<CursoModel> {
    override fun create(model: CursoModel) = try {
        val sql = """
            INSERT INTO Curso
            VALUES (${model.codigo}, '${model.nome}', ${model.codigoDepto})
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(vararg keys: String) = try {
        val sql = """
            SELECT * FROM Curso
            WHERE codigo = ${keys[0]}
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: CursoModel, vararg keys: String) = try {
        val sql = """
            UPDATE Curso
            SET codigo = ${model.codigo},
                nome = '${model.nome}',
                codigo_depto = ${model.codigoDepto}
            WHERE codigo = ${keys[0]}
        """.trimIndent()
        val curso = read(*keys)

        executeSql(sql)
        curso
    } catch (e: Exception) {
        null
    }

    override fun delete(vararg keys: String) = try {
        val sql = """
            DELETE FROM Curso
            WHERE codigo = ${keys[0]}
        """.trimIndent()
        val curso = read(*keys)

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
        val codigo = resultSet.getInt("codigo")
        val nome = resultSet.getString("nome")
        val codigoDepto = resultSet.getInt("codigo_depto")

        return CursoModel(codigo, nome, codigoDepto)
    }
}