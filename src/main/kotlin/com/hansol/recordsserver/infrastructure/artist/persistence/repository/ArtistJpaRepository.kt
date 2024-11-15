package com.hansol.recordsserver.infrastructure.artist.persistence.repository

import com.hansol.recordsserver.infrastructure.artist.persistence.entity.ArtistJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArtistJpaRepository : JpaRepository<ArtistJpaEntity, Long>, ArtistJpaRepositoryCustom {
}