package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.DepartamentoModel
import java.sql.ResultSet

object DepartamentoDAO : ReadWriteDAO<DepartamentoModel> {
    override fun create(model: DepartamentoModel) = try {
        val sql = """
            INSERT INTO Departamento
            VALUES (${model.codigo}, '${model.nome}')
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(vararg keys: String) = try {
        val sql = """
            SELECT * FROM Departamento
            WHERE codigo = ${keys[0]}
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: DepartamentoModel, vararg keys: String) = try {
        val sql = """
            UPDATE Departamento
            SET codigo = ${model.codigo},
                nome = '${model.nome}'
            WHERE codigo = ${keys[0]} 
        """.trimIndent()
        val departamento = read(*keys)

        executeSql(sql)
        departamento
    } catch (e: Exception) {
        null
    }

    override fun delete(vararg keys: String) = try {
        val sql = """
            DELETE FROM Departamento
            WHERE codigo = ${keys[0]}
        """.trimIndent()
        val departamento = read(*keys)

        executeSql(sql)
        departamento
    } catch (e: Exception) {
        null
    }

    override fun index(predicate: (DepartamentoModel) -> Boolean) = try {
        val sql = "SELECT * FROM Departamento"
        executeSql(sql).filter(predicate)
    } catch (e: Exception) {
        listOf()
    }

    override fun transform(resultSet: ResultSet): DepartamentoModel {
        val codigo = resultSet.getInt("codigo")
        val nome = resultSet.getString("nome")

        return DepartamentoModel(codigo, nome)
    }
}