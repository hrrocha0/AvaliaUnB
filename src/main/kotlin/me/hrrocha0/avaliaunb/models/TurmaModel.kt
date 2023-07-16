package me.hrrocha0.avaliaunb.models

data class TurmaModel(
    val codigoDisciplina: String,
    val codigo: Int,
    val periodo: String,
    val nomeProfessor: String,
    val horario: String,
    val vagasOcupadas: Int,
    val totalVagas: Int,
    val local: String,
    val codigoDepto: Int,
) : Model {
    override fun toMap() = mapOf(
        "codigo_disciplina" to codigoDisciplina,
        "codigo" to codigo,
        "periodo" to periodo,
        "nome_professor" to nomeProfessor,
        "horario" to horario,
        "vagas_ocupadas" to vagasOcupadas,
        "total_vagas" to totalVagas,
        "local" to local,
        "codigo_depto" to codigoDepto,
    )
}