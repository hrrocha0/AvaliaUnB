package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.Model

interface ReadWriteDAO<M : Model> : DataAccessObject<M> {
    fun create(model: M): M?
    fun update(model: M): M?
    fun delete(key: String): M?
}