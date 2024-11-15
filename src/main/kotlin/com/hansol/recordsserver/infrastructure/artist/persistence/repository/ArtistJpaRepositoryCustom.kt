package com.hansol.recordsserver.infrastructure.artist.persistence.repository

import com.hansol.recordsserver.application.artist.command.ArtistSearchCommand
import com.hansol.recordsserver.infrastructure.artist.persistence.entity.ArtistJpaEntity

interface ArtistJpaRepositoryCustom {
    fun search(command: ArtistSearchCommand): List<ArtistJpaEntity>
}