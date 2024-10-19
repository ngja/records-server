package com.hansol.recordsserver.presentation.common.dto

data class ResponseWrapper<T>(
    val result: T,
) {
    companion object {
        fun <T> success(result: T): ResponseWrapper<T> {
            return ResponseWrapper(result = result)
        }
    }
}
