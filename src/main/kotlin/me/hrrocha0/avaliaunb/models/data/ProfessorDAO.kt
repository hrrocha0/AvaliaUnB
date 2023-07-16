package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.ProfessorModel
import java.sql.ResultSet

object ProfessorDAO : ReadWriteDAO<ProfessorModel> {
    override fun create(model: ProfessorModel) = try {
        val sql = """
            INSERT INTO Professor
            VALUES ('${model.nome}', ${model.codigoDepto}, ${model.codigoPouD})
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(vararg keys: String) = try {
        val sql = """
            SELECT * FROM Professor
            WHERE nome = '${keys[0]}'
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: ProfessorModel, vararg keys: String) = try {
        val sql = """
            UPDATE Professor
            SET nome = '${model.nome}',
                codigo_depto = ${model.codigoDepto},
                codigo_p_ou_d = ${model.codigoPouD}
            WHERE nome = '${keys[0]}' 
        """.trimIndent()
        val professor = read(*keys)

        executeSql(sql)
        professor
    } catch (e: Exception) {
        null
    }

    override fun delete(vararg keys: String) = try {
        val sql = """
            DELETE FROM Professor
            WHERE nome = '${keys[0]}'
        """.trimIndent()
        val professor = read(*keys)

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
        val nome = resultSet.getString("nome")
        val codigoDepto = resultSet.getInt("codigo_depto")
        val codigoPouD = resultSet.getInt("codigo_p_ou_d")

        return ProfessorModel(nome, codigoDepto, codigoPouD)
    }
}