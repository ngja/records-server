package com.hansol.recordsserver.common.utils

import com.hansol.recordsserver.common.exception.FailedToParseException
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

object DateTimeParser {

    fun toDate(date: String): LocalDate {
        return try {
            LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE)
        } catch (e: DateTimeParseException) {
            throw FailedToParseException("유효하지 않은 날짜 형식입니다. yyyy-MM-dd 형식으로 입력해주세요.", date)
        }
    }

    fun toString(date: LocalDate): String {
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE)
    }

    fun toDateTime(dateTime: String): LocalDateTime {
        return try {
            LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        } catch (e: DateTimeParseException) {
            throw FailedToParseException("유효하지 않은 날짜/시간 형식입니다. yyyy-MM-dd'T'HH:mm:ss 형식으로 입력해주세요.", dateTime)
        }
    }

    fun toString(dateTime: LocalDateTime): String {
        return dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    }
}