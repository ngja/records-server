package com.hansol.recordsserver.presentation.common.dto

data class NoOffsetResponseWrapper<T : Cursored>(
    val results: List<T>,
    val hasNext: Boolean,
    val before: String?,
    val next: String?,
    val size: Int,
) {
    constructor(results: List<T>, hasNext: Boolean) : this(results, hasNext, results.first().cursor(), results.last().cursor(), results.size)
}
