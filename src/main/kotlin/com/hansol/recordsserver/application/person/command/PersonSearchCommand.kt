package com.hansol.recordsserver.application.person.command

data class PersonSearchCommand(
    val cursor: Long?,
    val size: Long,
)
