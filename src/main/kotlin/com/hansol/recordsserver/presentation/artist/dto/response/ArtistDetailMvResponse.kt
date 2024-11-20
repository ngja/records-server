package com.hansol.recordsserver.presentation.artist.dto.response

import com.hansol.recordsserver.application.music.domain.Mv
import com.hansol.recordsserver.common.utils.IdUtils

data class ArtistDetailMvResponse(
    val id: String,
    val url: String,
) {
    constructor(mv: Mv) : this(
        id = IdUtils.encode(mv.id),
        url = mv.url,
    )
}
