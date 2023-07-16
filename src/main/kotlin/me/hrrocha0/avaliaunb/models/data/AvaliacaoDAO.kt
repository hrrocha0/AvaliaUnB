package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.AvaliacaoModel
import java.sql.ResultSet

object AvaliacaoDAO : ReadWriteDAO<AvaliacaoModel> {
    override fun create(model: AvaliacaoModel) = try {
        val sql = """
            INSERT INTO Avaliacao
            VALUES (${model.codigoPouD}, ${model.codigo}, ${model.nota}, '${model.comentario}', '${model.matriculaEstudante}')
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(vararg keys: String) = try {
        val sql = """
            SELECT * FROM Avaliacao
            WHERE codigo_p_ou_d = ${keys[0]} AND codigo = ${keys[1]}
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: AvaliacaoModel, vararg keys: String) = try {
        val sql = """
            UPDATE Avaliacao
            SET codigo_p_ou_d = ${model.codigoPouD},
                codigo = ${model.codigo},
                nota = ${model.nota},
                comentario = '${model.comentario}',
                matricula_estudante = '${model.matriculaEstudante}'
            WHERE codigo_p_ou_d = ${keys[0]} AND codigo = ${keys[1]} 
        """.trimIndent()
        val avaliacao = read(*keys)

        executeSql(sql)
        avaliacao
    } catch (e: Exception) {
        null
    }

    override fun delete(vararg keys: String) = try {
        val sql = """
            DELETE FROM Avaliacao
            WHERE codigo_p_ou_d = ${keys[0]} AND codigo = ${keys[1]}
        """.trimIndent()
        val avaliacao = read(*keys)

        executeSql(sql)
        avaliacao
    } catch (e: Exception) {
        null
    }

    override fun index(predicate: (AvaliacaoModel) -> Boolean) = try {
        val sql = "SELECT * FROM Avaliacao"
        executeSql(sql).filter(predicate)
    } catch (e: Exception) {
        listOf()
    }

    override fun transform(resultSet: ResultSet): AvaliacaoModel {
        val codigoPouD = resultSet.getInt("codigo_p_ou_d")
        val codigo = resultSet.getInt("codigo")
        val nota = resultSet.getInt("nota")
        val comentario = resultSet.getString("comentario")
        val matriculaEstudante = resultSet.getString("matricula_estudante")

        return AvaliacaoModel(codigoPouD, codigo, nota, comentario, matriculaEstudante)
    }
}