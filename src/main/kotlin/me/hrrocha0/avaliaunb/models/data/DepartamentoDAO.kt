package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.DepartamentoModel
import java.sql.ResultSet

object DepartamentoDAO : ReadWriteDAO<DepartamentoModel> {
    override fun create(model: DepartamentoModel) = try {
        val sql = """
            INSERT INTO Departamento
            VALUES (${model.codigo}, '${model.sigla}', '${model.nome}')
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(key: String) = try {
        val sql = """
            SELECT * FROM Departamento
            WHERE id = $key
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: DepartamentoModel) = try {
        val sql = """
            UPDATE Departamento
            SET sigla = '${model.sigla}',
                nome = '${model.nome}'
            WHERE id = ${model.codigo} 
        """.trimIndent()
        val departamento = read(model.codigo.toString())

        executeSql(sql)
        departamento
    } catch (e: Exception) {
        null
    }

    override fun delete(key: String) = try {
        val sql = """
            DELETE FROM Departamento
            WHERE id = $key
        """.trimIndent()
        val departamento = read(key)

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
        val id = resultSet.getInt("id")
        val sigla = resultSet.getString("sigla")
        val nome = resultSet.getString("nome")

        return DepartamentoModel(id, sigla, nome)
    }
}