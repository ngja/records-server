package com.hansol.recordsserver.presentation.artist.dto.response

import com.hansol.recordsserver.application.artist.model.ArtistDetailModel
import com.hansol.recordsserver.common.utils.DateTimeParser
import com.hansol.recordsserver.common.vo.Image

data class ArtistDetailResponse(
    val id: String,
    val name: String,
    val description: String,
    val debutDate: String,
    val status: String,
    val mainImage: Image,
    val members: List<MemberResponse>,
) {

    constructor(artistDetailModel: ArtistDetailModel) : this(
        id = artistDetailModel.id,
        name = artistDetailModel.name,
        description = artistDetailModel.description,
        debutDate = DateTimeParser.toString(artistDetailModel.debutDate.toLocalDate()),
        status = artistDetailModel.status.label,
        mainImage = artistDetailModel.mainImage,
        members = artistDetailModel.members.map { MemberResponse(it) },
    )
}
