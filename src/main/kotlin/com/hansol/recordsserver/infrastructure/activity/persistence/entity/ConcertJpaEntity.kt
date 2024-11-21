package com.hansol.recordsserver.infrastructure.activity.persistence.entity

import com.hansol.recordsserver.application.activity.domain.Concert
import com.hansol.recordsserver.common.enums.ConcertType
import com.hansol.recordsserver.infrastructure.common.persistence.entity.AuditBaseEntity
import com.hansol.recordsserver.infrastructure.common.persistence.entity.ImageJpaEntity
import jakarta.persistence.*
import org.hibernate.annotations.SQLRestriction
import java.time.LocalDateTime

/**
 * 필요한 연관 데이터
 * 콘서트 셋리스트 concert_setlist
 * 콘서트 참가자 concert_artist
 * 콘서트 회차 (지역, 진행 날짜) concert_show
 */
@Entity
@Table(name = "concert")
@SQLRestriction("deleted = false")
class ConcertJpaEntity(
    @Id
    val id: Long,

    @Column(nullable = false)
    val name: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val type: ConcertType,

    @Column(nullable = false)
    val startDate: LocalDateTime,

    @Column(nullable = false)
    val endDate: LocalDateTime,

    @Embedded
    val image: ImageJpaEntity,
) : AuditBaseEntity() {

    fun toConcert(): Concert {
        return Concert(
            id = id,
            name = name,
            type = type,
            startDate = startDate,
            endDate = endDate,
            image = image.toImage()
        )
    }
}