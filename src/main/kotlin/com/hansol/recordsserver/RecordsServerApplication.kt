package com.hansol.recordsserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RecordsServerApplication

fun main(args: Array<String>) {
    runApplication<RecordsServerApplication>(*args)
}
