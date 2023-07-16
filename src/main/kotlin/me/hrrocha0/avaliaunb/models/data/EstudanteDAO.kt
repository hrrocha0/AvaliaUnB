package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.EstudanteModel
import java.sql.ResultSet

object EstudanteDAO : ReadWriteDAO<EstudanteModel> {
    override fun create(model: EstudanteModel) = try {
        val sql = """
            INSERT INTO Estudante
            VALUES ('${model.matricula}', '${model.nome}', '${model.email}', '${model.senha}', ${if (model.administrador) 1 else 0}, ${model.codigoCurso})
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(vararg keys: String) = try {
        val sql = """
            SELECT * FROM Estudante
            WHERE matricula = '${keys[0]}'
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: EstudanteModel, vararg keys: String) = try {
        val sql = """
            UPDATE Estudante
            SET matricula = '${model.matricula}'
                nome = '${model.nome}',
                email = '${model.email}',
                senha = '${model.senha}',
                administrador = ${if (model.administrador) 1 else 0},
                codigo_curso = ${model.codigoCurso}
            WHERE matricula = '${keys[0]}' 
        """.trimIndent()
        val estudante = read(*keys)

        executeSql(sql)
        estudante
    } catch (e: Exception) {
        null
    }

    override fun delete(vararg keys: String) = try {
        val sql = """
            DELETE FROM Estudante
            WHERE matricula = '${keys[0]}'
        """.trimIndent()
        val estudante = read(*keys)

        executeSql(sql)
        estudante
    } catch (e: Exception) {
        null
    }

    override fun index(predicate: (EstudanteModel) -> Boolean) = try {
        val sql = "SELECT * FROM Estudante"
        executeSql(sql).filter(predicate)
    } catch (e: Exception) {
        listOf()
    }

    override fun transform(resultSet: ResultSet): EstudanteModel {
        val matricula = resultSet.getString("matricula")
        val nome = resultSet.getString("nome")
        val email = resultSet.getString("email")
        val senha = resultSet.getString("senha")
        val administrador = resultSet.getBoolean("admin")
        val codigoCurso = resultSet.getInt("codigo_curso")

        return EstudanteModel(matricula, nome, email, senha, administrador, codigoCurso)
    }
}