package com.hansol.recordsserver.application.artist.command

data class ArtistSearchCommand(
    val cursor: Long?,
    val size: Long,
)
