package com.hansol.recordsserver.presentation.common.config

import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.stereotype.Component

@Component
@EnableJpaAuditing
class JpaConfig {
}