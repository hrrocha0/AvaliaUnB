package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.DenunciaModel
import java.sql.ResultSet

object DenunciaDAO : ReadWriteDAO<DenunciaModel> {
    override fun create(model: DenunciaModel) = try {
        val sql = """
            INSERT INTO Denuncia
            VALUES (${model.idPouD}, ${model.idAvaliacao}, ${model.id}, '${model.comentario}', '${model.matriculaEstudante}', '${model.matriculaAvaliador}')
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(key: String) = try {
        val (idPouD, idAvaliacao, id) = key.split(",")
        val sql = """
            SELECT * FROM Denuncia
            WHERE id_p_ou_d = $idPouD AND id_avaliacao=$idAvaliacao AND id = $id
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: DenunciaModel) = try {
        val sql = """
            UPDATE Denuncia
            SET comentario = '${model.comentario}',
                matricula_estudante = '${model.matriculaEstudante}',
                matricula_avaliador = '${model.matriculaAvaliador}'
            WHERE id_p_ou_d = ${model.idPouD} AND id_avaliacao = ${model.idAvaliacao} AND id = ${model.id} 
        """.trimIndent()
        val denuncia = read("${model.idPouD},${model.idAvaliacao},${model.id}")

        executeSql(sql)
        denuncia
    } catch (e: Exception) {
        null
    }

    override fun delete(key: String) = try {
        val (idPouD, idAvaliacao, id) = key.split(",")
        val sql = """
            DELETE FROM Denuncia
            WHERE id_p_ou_d = $idPouD AND id_avaliacao = $idAvaliacao AND id = $id
        """.trimIndent()
        val denuncia = read(key)

        executeSql(sql)
        denuncia
    } catch (e: Exception) {
        null
    }

    override fun index(predicate: (DenunciaModel) -> Boolean) = try {
        val sql = "SELECT * FROM Denuncia"
        executeSql(sql).filter(predicate)
    } catch (e: Exception) {
        listOf()
    }

    override fun transform(resultSet: ResultSet): DenunciaModel {
        val idPouD = resultSet.getInt("id_p_ou_d")
        val idAvaliacao = resultSet.getInt("id_avaliacao")
        val id = resultSet.getInt("id")
        val comentario = resultSet.getString("comentario")
        val matriculaEstudante = resultSet.getString("matricula_estudante")
        val matriculaAvaliador = resultSet.getString("matricula_avaliador")

        return DenunciaModel(idPouD, idAvaliacao, id, comentario, matriculaEstudante, matriculaAvaliador)
    }
}