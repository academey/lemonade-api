package com.lemonade.server.domain.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.testcontainers.containers.GenericContainer

@Configuration
class EmbeddedRedisConfig {
    @Bean
    fun redisContainer(): GenericContainer<*> {
        val redisContainer = GenericContainer(DOCKER_IMAGE).withExposedPorts(6379)
        redisContainer.start()
        return redisContainer
    }

    @Bean
    @Primary
    fun redisConnectionFactory(): LettuceConnectionFactory {
        return LettuceConnectionFactory(redisContainer().host, redisContainer().firstMappedPort)
    }

    companion object {
        private const val DOCKER_IMAGE = "redis"
    }
}
