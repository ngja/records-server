package com.hansol.recordsserver.infrastructure.artist.persistence.entity

import com.hansol.recordsserver.application.artist.domain.Member
import com.hansol.recordsserver.common.enums.MemberStatus
import com.hansol.recordsserver.infrastructure.common.persistence.entity.AuditBaseEntity
import com.hansol.recordsserver.infrastructure.common.persistence.entity.ImageJpaEntity
import com.hansol.recordsserver.infrastructure.person.persistence.entity.PersonJpaEntity
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

    @ManyToOne
    @JoinColumn(name = "person_id")
    val person: PersonJpaEntity,

    @Column(nullable = false)
    val name: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val status: MemberStatus,

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