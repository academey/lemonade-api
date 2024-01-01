package com.lemonade.server.infra

import org.junit.jupiter.api.Test
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = ["com.lemonade.server.infra"])
class TestConfiguration {
    @Test
    fun hi() {
        println("test")
    }
}
