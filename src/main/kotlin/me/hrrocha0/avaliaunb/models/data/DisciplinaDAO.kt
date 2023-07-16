package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.DisciplinaModel
import java.sql.ResultSet

object DisciplinaDAO : ReadWriteDAO<DisciplinaModel> {
    override fun create(model: DisciplinaModel) = try {
        val sql = """
            INSERT INTO Disciplina
            VALUES (${model.id}, '${model.codigo}', '${model.nome}', '${model.descricao}', ${model.codigoDepto})
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(key: String) = try {
        val sql = """
            SELECT * FROM Disciplina
            WHERE id = $key
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: DisciplinaModel) = try {
        val sql = """
            UPDATE Disciplina
            SET codigo = '${model.codigo}',
                nome = '${model.nome}',
                descricao = '${model.descricao}',
                id_departamento = ${model.codigoDepto}
            WHERE id = ${model.id} 
        """.trimIndent()
        val disciplina = read(model.id.toString())

        executeSql(sql)
        disciplina
    } catch (e: Exception) {
        null
    }

    override fun delete(key: String) = try {
        val sql = """
            DELETE FROM Disciplina
            WHERE id = $key
        """.trimIndent()
        val disciplina = read(key)

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
        val id = resultSet.getInt("id")
        val codigo = resultSet.getString("codigo")
        val nome = resultSet.getString("nome")
        val descricao = resultSet.getString("descricao")
        val idDepartamento = resultSet.getInt("id_departamento")

        return DisciplinaModel(id, codigo, nome, descricao, idDepartamento)
    }
}