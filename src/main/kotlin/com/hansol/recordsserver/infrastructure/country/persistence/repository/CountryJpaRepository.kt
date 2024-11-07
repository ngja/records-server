package com.hansol.recordsserver.infrastructure.country.persistence.repository

import com.hansol.recordsserver.infrastructure.country.persistence.entity.CountryJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CountryJpaRepository : JpaRepository<CountryJpaEntity, Long> {
}