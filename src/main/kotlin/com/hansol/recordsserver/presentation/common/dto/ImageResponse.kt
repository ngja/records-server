package com.hansol.recordsserver.presentation.common.dto

import com.hansol.recordsserver.common.vo.Image

data class ImageResponse(
    val width: Int,
    val height: Int,
    val path: String,
) {
    constructor(image: Image) : this(
        width = image.width,
        height = image.height,
        path = image.path,
    )
}
