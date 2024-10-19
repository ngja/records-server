package com.hansol.recordsserver.application.person.validator

object PersonFieldValidator {
    private const val MAX_SURNAME_LENGTH = 100
    private const val MAX_FORENAME_LENGTH = 100

    fun validateSurname(surname: String) {
        require(surname.isNotEmpty()) { "Surname cannot be empty" }
        require(surname.length <= MAX_SURNAME_LENGTH) { "Surname cannot exceed $MAX_SURNAME_LENGTH characters" }
    }

    fun validateForename(forename: String) {
        require(forename.isNotEmpty()) { "Forename cannot be empty" }
        require(forename.length <= MAX_FORENAME_LENGTH) { "Forename cannot exceed $MAX_FORENAME_LENGTH characters" }
    }
}