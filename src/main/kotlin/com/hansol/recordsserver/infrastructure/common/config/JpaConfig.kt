package com.hansol.recordsserver.infrastructure.common.config

import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.stereotype.Component

@Component
@EnableJpaAuditing
class JpaConfig {
}