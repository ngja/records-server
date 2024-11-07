package com.hansol.recordsserver.application.country.repository

import com.hansol.recordsserver.application.country.domain.Country

interface CountryWriteRepository {
    fun create(country: Country): Country
    fun createAll(countryList: Collection<Country>): List<Country>
}