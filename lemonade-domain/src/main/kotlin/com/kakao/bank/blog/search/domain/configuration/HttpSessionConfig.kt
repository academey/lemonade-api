package com.kakao.bank.blog.search.domain.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession
import org.springframework.session.web.http.HeaderHttpSessionIdResolver
import org.springframework.session.web.http.HttpSessionIdResolver

@Configuration
@EnableRedisHttpSession
class HttpSessionConfig {
    @Bean
    fun connectionFactory(): LettuceConnectionFactory {
        return LettuceConnectionFactory()
    }

    @Bean
    fun httpSessionIdResolver(): HttpSessionIdResolver {
        return HeaderHttpSessionIdResolver.xAuthToken()
    }
}
