package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.AvaliacaoModel
import java.sql.ResultSet

object AvaliacaoDAO : ReadWriteDAO<AvaliacaoModel> {
    override fun create(model: AvaliacaoModel) = try {
        val sql = """
            INSERT INTO Avaliacao
            VALUES (${model.idPouD}, ${model.id}, ${model.nota}, '${model.comentario}', '${model.matriculaEstudante}')
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(key: String) = try {
        val (idPouD, id) = key.split(",")
        val sql = """
            SELECT * FROM Avaliacao
            WHERE id_p_ou_d = $idPouD AND id = $id
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: AvaliacaoModel) = try {
        val sql = """
            UPDATE Avaliacao
            SET nota = ${model.nota},
                comentario = '${model.comentario}',
                matricula_estudante = '${model.matriculaEstudante}'
            WHERE id_p_ou_d = ${model.idPouD} AND id = ${model.id} 
        """.trimIndent()
        val avaliacao = read("${model.idPouD},${model.id}")

        executeSql(sql)
        avaliacao
    } catch (e: Exception) {
        null
    }

    override fun delete(key: String) = try {
        val (idPouD, id) = key.split(",")
        val sql = """
            DELETE FROM Avaliacao
            WHERE id_p_ou_d = $idPouD AND id = $id
        """.trimIndent()
        val avaliacao = read(key)

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
        val idPouD = resultSet.getInt("id_p_ou_d")
        val id = resultSet.getInt("id")
        val nota = resultSet.getInt("nota")
        val comentario = resultSet.getString("comentario")
        val matriculaEstudante = resultSet.getString("matricula_estudante")

        return AvaliacaoModel(idPouD, id, nota, comentario, matriculaEstudante)
    }
}