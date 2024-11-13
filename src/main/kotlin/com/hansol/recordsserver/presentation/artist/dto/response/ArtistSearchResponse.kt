package com.hansol.recordsserver.presentation.artist.dto.response

import com.hansol.recordsserver.application.artist.model.ArtistSearchModel
import com.hansol.recordsserver.common.utils.DateTimeParser
import com.hansol.recordsserver.presentation.common.dto.Cursored

data class ArtistSearchResponse (
    val id: String,
    val name: String,
    val debutDate: String,
    val status: String,
) : Cursored {

    constructor(artistSearchModel: ArtistSearchModel) : this(
        id = artistSearchModel.id,
        name = artistSearchModel.name,
        debutDate = DateTimeParser.toString(artistSearchModel.debutDate.toLocalDate()),
        status = artistSearchModel.status.label,
    )

    override fun cursor(): String {
        return id
    }
}
