package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.PouDModel
import java.sql.ResultSet

object PouDDAO : ReadWriteDAO<PouDModel> {
    override fun create(model: PouDModel) = try {
        val sql = """
            INSERT INTO PouD
            VALUES (${model.id})
        """.trimIndent()

        executeSql(sql)
        model
    } catch (e: Exception) {
        null
    }

    override fun read(key: String) = try {
        val sql = """
            SELECT * FROM PouD
            WHERE id = $key
        """.trimIndent()

        executeSql(sql).first()
    } catch (e: Exception) {
        null
    }

    override fun update(model: PouDModel) = try {
        val pouD = read(model.id.toString())

        // Update does nothing to PouD
        pouD
    } catch (e: Exception) {
        null
    }

    override fun delete(key: String) = try {
        val sql = """
            DELETE FROM PouD
            WHERE id = $key
        """.trimIndent()
        val pouD = read(key)

        executeSql(sql)
        pouD
    } catch (e: Exception) {
        null
    }

    override fun index(predicate: (PouDModel) -> Boolean) = try {
        val sql = "SELECT * FROM PouD"
        executeSql(sql).filter(predicate)
    } catch (e: Exception) {
        listOf()
    }

    override fun transform(resultSet: ResultSet): PouDModel {
        val id = resultSet.getInt("id")
        return PouDModel(id)
    }
}