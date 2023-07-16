package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.DisciplinaModel
import java.sql.ResultSet

object DisciplinaDAO : ReadWriteDAO<DisciplinaModel> {
    override fun create(model: DisciplinaModel) = try {
        val sql = """
            INSERT INTO Disciplina
            VALUES ('${model.codigo}', '${model.nome}', ${model.codigoDepto}, ${model.codigoPouD})
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(vararg keys: String) = try {
        val sql = """
            SELECT * FROM Disciplina
            WHERE codigo = '${keys[0]}'
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: DisciplinaModel, vararg keys: String) = try {
        val sql = """
            UPDATE Disciplina
            SET codigo = '${model.codigo}',
                nome = '${model.nome}',
                codigo_depto = ${model.codigoDepto},
                codigo_p_ou_d = ${model.codigoPouD}
            WHERE codigo = '${keys[0]}'
        """.trimIndent()
        val disciplina = read(*keys)

        executeSql(sql)
        disciplina
    } catch (e: Exception) {
        null
    }

    override fun delete(vararg keys: String) = try {
        val sql = """
            DELETE FROM Disciplina
            WHERE codigo = '${keys[0]}'
        """.trimIndent()
        val disciplina = read(*keys)

        executeSql(sql)
        disciplina
    } catch (e: Exception) {
        null
    }

    override fun index(predicate: (DisciplinaModel) -> Boolean) = try {
        val sql = "SELECT * FROM Disciplina"
        executeSql(sql).filter(predicate)
    } catch (e: Exception) {
        listOf()
    }

    override fun transform(resultSet: ResultSet): DisciplinaModel {
        val codigo = resultSet.getString("codigo")
        val nome = resultSet.getString("nome")
        val codigoDepto = resultSet.getInt("codigo_depto")
        val codigoPouD = resultSet.getInt("codigo_p_ou_d")

        return DisciplinaModel(codigo, nome, codigoDepto, codigoPouD)
    }
}