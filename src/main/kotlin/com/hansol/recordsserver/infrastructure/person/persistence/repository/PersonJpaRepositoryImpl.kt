package com.hansol.recordsserver.infrastructure.person.persistence.repository

import com.hansol.recordsserver.application.person.command.PersonSearchCommand
import com.hansol.recordsserver.infrastructure.person.persistence.entity.PersonJpaEntity
import com.hansol.recordsserver.infrastructure.person.persistence.entity.QPersonJpaEntity.personJpaEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class PersonJpaRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : PersonJpaRepositoryCustom {
    override fun search(command: PersonSearchCommand): List<PersonJpaEntity> {
        return jpaQueryFactory.selectFrom(personJpaEntity)
            .where(
                if (command.cursor != null) personJpaEntity.id.lt(command.cursor) else null
            )
            .orderBy(personJpaEntity.id.desc())
            .limit(command.size)
            .fetch()
    }
}