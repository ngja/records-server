package com.hansol.recordsserver.presentation.person.dto.request

import com.hansol.recordsserver.application.person.command.PersonSearchCommand
import com.hansol.recordsserver.common.constants.PageSize

data class PersonSearchRequest(
    val cursor: String? = null,
    val size: Int? = PageSize.DEFAULT_PAGE_SIZE,
) {
    fun toCommand(): PersonSearchCommand {
        return PersonSearchCommand(
            cursor = cursor,
            size = size ?: PageSize.DEFAULT_PAGE_SIZE,
        )
    }
}
