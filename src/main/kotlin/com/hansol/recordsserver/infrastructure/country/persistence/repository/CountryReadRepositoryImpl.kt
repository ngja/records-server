package com.hansol.recordsserver.infrastructure.country.persistence.repository

import com.hansol.recordsserver.application.country.domain.Country
import com.hansol.recordsserver.application.country.repository.CountryReadRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional(readOnly = true)
class CountryReadRepositoryImpl(
    private val countryJpaRepository: CountryJpaRepository,
) : CountryReadRepository {

    override fun getAllCountries(): List<Country> {
        return countryJpaRepository.findAll().map { it.toCountry() }
    }

    override fun findByIds(ids: Collection<Long>): List<Country> {
        return countryJpaRepository.findByIdIn(ids).map { it.toCountry() }
    }
}