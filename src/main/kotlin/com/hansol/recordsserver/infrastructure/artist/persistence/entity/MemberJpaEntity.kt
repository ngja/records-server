package com.hansol.recordsserver.infrastructure.artist.persistence.entity

import com.hansol.recordsserver.application.artist.domain.Member
import com.hansol.recordsserver.infrastructure.common.persistence.entity.AuditBaseEntity
import com.hansol.recordsserver.infrastructure.common.persistence.entity.ImageJpaEntity
import jakarta.persistence.*
import org.hibernate.annotations.SQLRestriction

@Entity
@Table(name = "member")
@SQLRestriction("deleted = false")
class MemberJpaEntity(
    @Id
    val id: Long,

    @Column(nullable = false)
    val artistId: Long,

    @Column(nullable = false)
    val name: String,

    @Embedded
    val image: ImageJpaEntity,
) : AuditBaseEntity() {

    fun toMember(): Member {
        return Member(
            id = id,
            name = name,
            image = image.toImage()
        )
    }
}