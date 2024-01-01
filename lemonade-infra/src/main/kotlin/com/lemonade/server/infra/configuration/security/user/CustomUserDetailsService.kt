package com.lemonade.server.infra.configuration.security.user

import com.lemonade.server.domain.user.UserService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userService: UserService,
) : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(email: String): UserDetails {
        return userService.findByEmail(email)
            ?: throw UsernameNotFoundException("사용자를 찾을 수 없습니다. email=$email")
    }
}
