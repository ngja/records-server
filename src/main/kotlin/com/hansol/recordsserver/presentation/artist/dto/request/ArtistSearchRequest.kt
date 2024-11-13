package com.hansol.recordsserver.presentation.artist.dto.request

import com.hansol.recordsserver.application.artist.command.ArtistSearchCommand
import com.hansol.recordsserver.common.constants.PageSize
import com.hansol.recordsserver.common.utils.IdUtils

data class ArtistSearchRequest(
    val cursor: String? = null,
    val size: Long = PageSize.DEFAULT_PAGE_SIZE,
) {
    fun toCommand(): ArtistSearchCommand {
        return ArtistSearchCommand(
            cursor = cursor?.let { IdUtils.decode(cursor) },
            size = size,
        )
    }
}
