package com.hansol.recordsserver.common.exception

class FailedToParseException(
    private val clientMessage: String,
    private val serverMessage: String,
    private val input: String?,
) : RuntimeException(clientMessage) {

    constructor(clientMessage: String) : this(clientMessage, clientMessage, null)

    constructor(clientMessage: String, input: String) : this(clientMessage, clientMessage, input)
}