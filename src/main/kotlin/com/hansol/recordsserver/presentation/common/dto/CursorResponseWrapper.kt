package com.hansol.recordsserver.presentation.common.dto

data class CursorResponseWrapper<T>(
    val results: List<T>,
)
