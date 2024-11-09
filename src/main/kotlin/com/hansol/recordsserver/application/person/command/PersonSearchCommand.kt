package com.hansol.recordsserver.application.person.command

data class PersonSearchCommand(
    val cursor: String?,
    val size: Int,
)
