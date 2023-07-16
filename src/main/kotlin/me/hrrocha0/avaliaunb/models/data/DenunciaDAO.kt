package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.DenunciaModel
import java.sql.ResultSet

object DenunciaDAO : ReadWriteDAO<DenunciaModel> {
    override fun create(model: DenunciaModel) = try {
        val sql = """
            INSERT INTO Denuncia
            VALUES (${model.codigoPouD}, ${model.codigoAvaliacao}, ${model.codigo}, '${model.comentario}', '${model.matriculaEstudante}', '${model.matriculaAdministrador}')
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(vararg keys: String) = try {
        val sql = """
            SELECT * FROM Denuncia
            WHERE codigo_p_ou_d = ${keys[0]} AND codigo_avaliacao=${keys[1]} AND codigo = ${keys[2]}
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: DenunciaModel, vararg keys: String) = try {
        val sql = """
            UPDATE Denuncia
            SET codigo_p_ou_d = ${model.codigoPouD},
                codigo_avaliacao = ${model.codigoAvaliacao},
                codigo = ${model.codigo},
                comentario = '${model.comentario}',
                matricula_estudante = '${model.matriculaEstudante}',
                matricula_administrador = '${model.matriculaAdministrador}'
            WHERE codigo_p_ou_d = ${keys[0]} AND codigo_avaliacao = ${keys[1]} AND codigo = ${keys[2]} 
        """.trimIndent()
        val denuncia = read(*keys)

        executeSql(sql)
        denuncia
    } catch (e: Exception) {
        null
    }

    override fun delete(vararg keys: String) = try {
        val sql = """
            DELETE FROM Denuncia
            WHERE codigo_p_ou_d = ${keys[0]} AND codigo_avaliacao = ${keys[1]} AND codigo = ${keys[2]}
        """.trimIndent()
        val denuncia = read(*keys)

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
        val codigoPouD = resultSet.getInt("codigo_p_ou_d")
        val codigoAvaliacao = resultSet.getInt("codigo_avaliacao")
        val codigo = resultSet.getInt("codigo")
        val comentario = resultSet.getString("comentario")
        val matriculaEstudante = resultSet.getString("matricula_estudante")
        val matriculaAdministrador = resultSet.getString("matricula_administrador")

        return DenunciaModel(codigoPouD, codigoAvaliacao, codigo, comentario, matriculaEstudante, matriculaAdministrador)
    }
}