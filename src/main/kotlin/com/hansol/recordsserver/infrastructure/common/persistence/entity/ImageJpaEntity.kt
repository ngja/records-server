package com.hansol.recordsserver.infrastructure.common.persistence.entity

import com.hansol.recordsserver.common.vo.Image
import jakarta.persistence.Embeddable

@Embeddable
class ImageJpaEntity(
    val imageWidth: Int,
    val imageHeight: Int,
    val imagePath: String,
) {

    constructor(image: Image) : this(image.width, image.height, image.path)

    fun toImage(): Image {
        return Image(
            width = imageWidth,
            height = imageHeight,
            path = imagePath,
        )
    }
}