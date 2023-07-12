package me.hrrocha0.avaliaunb.models.data

import me.hrrocha0.avaliaunb.models.Model

interface ReadOnlyDAO<M : Model> : DataAccessObject<M>