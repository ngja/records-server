package com.hansol.recordsserver.infrastructure.country.persistence.entity

import com.hansol.recordsserver.application.country.domain.Country
import com.hansol.recordsserver.infrastructure.common.persistence.entity.AuditBaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.SQLRestriction

@Entity
@Table(name = "country")
@SQLRestriction("deleted = false")
class CountryJpaEntity(
    @Id
    val id: Long,

    @Column(nullable = false, length = 255)
    val name: String,

    @Column(nullable = false, length = 255)
    val englishName: String,

    @Column(name = "alpha_2", nullable = false, length = 2)
    val alpha2: String,

    @Column(name = "alpha_3", nullable = false, length = 3)
    val alpha3: String,
) : AuditBaseEntity() {

    companion object {
        fun fromCountry(country: Country): CountryJpaEntity {
            return CountryJpaEntity(
                id = country.id,
                name = country.name,
                englishName = country.englishName,
                alpha2 = country.alpha2,
                alpha3 = country.alpha3
            )
        }
    }

    fun toCountry(): Country {
        return Country(
            id = this.id,
            name = this.name,
            englishName = this.englishName,
            alpha2 = this.alpha2,
            alpha3 = this.alpha3
        )
    }
}