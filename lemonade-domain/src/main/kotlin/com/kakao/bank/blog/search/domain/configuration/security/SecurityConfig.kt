package com.kakao.bank.blog.search.domain.configuration.security

import com.kakao.bank.blog.search.domain.configuration.security.user.CustomUserDetailsService
import com.kakao.bank.blog.search.domain.user.Role
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.savedrequest.NullRequestCache

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val customUserDetailsService: CustomUserDetailsService,
) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .authorizeHttpRequests { authorize ->
                authorize
                    .anyRequest().permitAll()
            }
            .requestCache { requestCache -> requestCache.requestCache(NullRequestCache()) }
            .httpBasic(Customizer.withDefaults())
            .sessionManagement { sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) }
            .csrf { c -> c.disable() }
            .userDetailsService(customUserDetailsService)
            .build()
    }

    @Autowired
    fun configureAdmin(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
            .withUser(User.withUsername("admin").password("{noop}admin").roles(Role.ADMIN.name).build())
    }
}
