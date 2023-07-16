package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.TurmaModel
import java.sql.ResultSet

object TurmaDAO : ReadWriteDAO<TurmaModel> {
    override fun create(model: TurmaModel) = try {
        val sql = """
            INSERT INTO Turma
            VALUES ('${model.codigoDisciplina}', ${model.codigo}, '${model.periodo}', '${model.nomeProfessor}', '${model.horario}', ${model.vagasOcupadas}, ${model.totalVagas}, '${model.local}', ${model.codigoDepto})
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(vararg keys: String) = try {
        val sql = """
            SELECT * FROM Turma
            WHERE codigo_disciplina = '${keys[0]}' AND codigo = ${keys[1]}
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: TurmaModel, vararg keys: String) = try {
        val sql = """
            UPDATE Turma
            SET codigo_disciplina = '${model.codigoDisciplina}',
                codigo = ${model.codigo},
                periodo = '${model.periodo}',
                nome_professor = '${model.nomeProfessor}',
                horario = '${model.horario}',
                vagas_ocupadas = ${model.vagasOcupadas},
                total_vagas = ${model.totalVagas},
                local = '${model.local}',
                codigo_depto = ${model.codigoDepto}
            WHERE codigo_disciplina = '${keys[0]}' AND codigo = ${keys[1]}
        """.trimIndent()
        val turma = read(*keys)

        executeSql(sql)
        turma
    } catch (e: Exception) {
        null
    }

    override fun delete(vararg keys: String) = try {
        val sql = """
            DELETE FROM Turma
            WHERE codigo_disciplina = '${keys[0]}' AND codigo = ${keys[1]}
        """.trimIndent()
        val turma = read(*keys)

        executeSql(sql)
        turma
    } catch (e: Exception) {
        null
    }

    override fun index(predicate: (TurmaModel) -> Boolean) = try {
        val sql = "SELECT * FROM Turma"
        executeSql(sql).filter(predicate)
    } catch (e: Exception) {
        listOf()
    }

    override fun transform(resultSet: ResultSet): TurmaModel {
        val codigoDisciplina = resultSet.getString("codigo_disciplina")
        val codigo = resultSet.getInt("codigo")
        val periodo = resultSet.getString("periodo")
        val nomeProfessor = resultSet.getString("nome_professor")
        val horario = resultSet.getString("horario")
        val vagasOcupadas = resultSet.getInt("vagas_ocupadas")
        val totalVagas = resultSet.getInt("total_vagas")
        val local = resultSet.getString("local")
        val codigoDepto = resultSet.getInt("codigo_depto")

        return TurmaModel(
            codigoDisciplina,
            codigo,
            periodo,
            nomeProfessor,
            horario,
            vagasOcupadas,
            totalVagas,
            local,
            codigoDepto
        )
    }
}