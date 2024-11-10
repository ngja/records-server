package com.hansol.recordsserver.presentation.person.dto.request

import com.hansol.recordsserver.application.person.command.PersonSearchCommand
import com.hansol.recordsserver.common.constants.PageSize
import com.hansol.recordsserver.common.utils.IdUtils

data class PersonSearchRequest(
    val cursor: String? = null,
    val size: Long? = PageSize.DEFAULT_PAGE_SIZE,
) {
    fun toCommand(): PersonSearchCommand {
        return PersonSearchCommand(
            cursor = cursor?.let { IdUtils.decode(it) },
            size = size ?: PageSize.DEFAULT_PAGE_SIZE,
        )
    }
}
