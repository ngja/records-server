package com.hansol.recordsserver.common.utils

import com.hansol.recordsserver.common.utils.Logger.logger
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class IdUtilsTest : StringSpec({

    "ID를 반복해서 생성한다" {
        val idSet = (1..10).map { IdUtils.generate() }.toSet()
        logger.info { "ids = $idSet" }
        idSet.size shouldBe 10
    }
})