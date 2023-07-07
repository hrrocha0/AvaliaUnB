package me.hrrocha0.avaliaunb.models

import me.hrrocha0.avaliaunb.models.data.Estudante

data class EstudanteModel(val estudante: Estudante) : Model<String> {
    override fun toMap() = mapOf(
        "matricula" to estudante.matricula,
        "nome" to estudante.nome,
        "email" to estudante.email,
        "senha" to estudante.senha,
    )
}