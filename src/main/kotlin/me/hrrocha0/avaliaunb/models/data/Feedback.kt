package me.hrrocha0.avaliaunb.models.data

sealed class Feedback(val type: String, open val message: String? = null) {
    data class Success(override val message: String? = null) : Feedback("success", message)
    data class Error(override val message: String? = null) : Feedback("error", message)
}