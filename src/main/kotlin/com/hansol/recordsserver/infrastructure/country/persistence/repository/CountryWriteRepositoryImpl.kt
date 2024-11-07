package com.hansol.recordsserver.infrastructure.country.persistence.repository

import com.hansol.recordsserver.application.country.domain.Country
import com.hansol.recordsserver.application.country.repository.CountryWriteRepository
import com.hansol.recordsserver.infrastructure.country.persistence.entity.CountryJpaEntity
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class CountryWriteRepositoryImpl(
    private val countryJpaRepository : CountryJpaRepository,
) : CountryWriteRepository {
    override fun create(country: Country): Country {
        val countryJpaEntity = CountryJpaEntity.fromCountry(country)
        val result = countryJpaRepository.save(countryJpaEntity)
        return result.toCountry()
    }

    override fun createAll(countryList: Collection<Country>): List<Country> {
        val countryJpaEntities = countryList.map { CountryJpaEntity.fromCountry(it) }
        val results = countryJpaRepository.saveAll(countryJpaEntities)
        return results.map { it.toCountry() }
    }
}