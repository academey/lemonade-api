package com.lemonade.server.infra.configuration.security

import com.lemonade.server.domain.user.Role
import com.lemonade.server.domain.user.UserService
import com.lemonade.server.infra.configuration.security.user.CustomUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.savedrequest.NullRequestCache

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val userService: UserService,
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
        if (userService.findByEmail("admin@admin.com") == null) {
            userService.signUp(
                email = "admin@admin.com",
                name = "admin",
                picture = null,
                rawPassword = "admin",
                role = Role.ADMIN,
            )
        }
    }
}
