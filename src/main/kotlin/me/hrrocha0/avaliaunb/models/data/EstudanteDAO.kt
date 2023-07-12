package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.EstudanteModel
import java.sql.ResultSet

object EstudanteDAO : ReadWriteDAO<EstudanteModel> {
    override fun create(model: EstudanteModel) = try {
        val sql = """
            INSERT INTO Estudante
            VALUES ('${model.matricula}', '${model.nome}', '${model.email}', '${model.senha}', ${if (model.admin) 1 else 0}, ${model.idCurso})
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(key: String) = try {
        val sql = """
            SELECT * FROM Estudante
            WHERE matricula = '$key'
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: EstudanteModel) = try {
        val sql = """
            UPDATE Estudante
            SET nome = '${model.nome},
                email = '${model.email}',
                senha = '${model.senha},
                admin = ${if (model.admin) 1 else 0},
                id_curso = ${model.idCurso}
            WHERE matricula = '${model.matricula}' 
        """.trimIndent()
        val estudante = read(model.matricula)

        executeSql(sql)
        estudante
    } catch (e: Exception) {
        null
    }

    override fun delete(key: String) = try {
        val sql = """
            DELETE FROM Estudante
            WHERE matricula = '$key'
        """.trimIndent()
        val estudante = read(key)

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
        val admin = resultSet.getBoolean("admin")
        val idCurso = resultSet.getInt("id_curso")

        return EstudanteModel(matricula, nome, email, senha, admin, idCurso)
    }
}