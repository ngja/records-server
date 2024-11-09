package com.hansol.recordsserver.common.utils

import com.github.f4b6a3.tsid.Tsid
import com.github.f4b6a3.tsid.TsidCreator

object IdUtils {
    fun generate(): Long {
        return TsidCreator.getTsid().toLong()
    }

    fun encode(id: Long): String {
        return Tsid.from(id).toString()
    }

    fun decode(string: String): Long {
        return Tsid.from(string).toLong()
    }
}