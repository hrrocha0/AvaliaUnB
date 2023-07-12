package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.PerfilModel
import java.sql.ResultSet

object PerfilDAO : ReadOnlyDAO<PerfilModel> {
    override fun read(key: String) = try {
        val sql = """
            SELECT * FROM Perfil
            WHERE matricula = '$key'
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
        val admin = resultSet.getBoolean("admin")
        val curso = resultSet.getString("curso")

        return PerfilModel(matricula, nome, email, admin, curso)
    }
}