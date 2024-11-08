package com.hansol.recordsserver.application.country.repository

import com.hansol.recordsserver.application.country.domain.Country

interface CountryReadRepository {
    fun getAllCountries(): List<Country>
    fun findByIds(ids: Collection<Long>): List<Country>
}