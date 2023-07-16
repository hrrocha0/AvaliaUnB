package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.PerfilModel
import java.sql.ResultSet

object PerfilDAO : ReadOnlyDAO<PerfilModel> {
    override fun read(vararg keys: String) = try {
        val sql = """
            SELECT * FROM Perfil
            WHERE matricula = '${keys[0]}'
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun index(predicate: (PerfilModel) -> Boolean) = try {
        val sql = "SELECT * FROM Perfil"
        executeSql(sql).filter(predicate)
    } catch (e: Exception) {
        listOf()
    }

    override fun transform(resultSet: ResultSet): PerfilModel {
        val matricula = resultSet.getString("matricula")
        val nome = resultSet.getString("nome")
        val email = resultSet.getString("email")
        val administrador = resultSet.getBoolean("admin")
        val nomeCurso = resultSet.getString("nome_curso")

        return PerfilModel(matricula, nome, email, administrador, nomeCurso)
    }
}