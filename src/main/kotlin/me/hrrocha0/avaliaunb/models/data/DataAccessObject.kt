package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.Model
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.ResultSet

interface DataAccessObject<M : Model> {
    fun read(key: String): M?
    fun index(predicate: (M) -> Boolean = { true }): List<M>

    fun transform(resultSet: ResultSet): M

    fun executeSql(sql: String) = transaction {
        buildList {
            TransactionManager.current().exec(sql) { resultSet ->
                while (resultSet.next()) add(transform(resultSet))
            }
        }
    }
}
