package com.lemonade.server.domain.user

import com.lemonade.server.utils.CustomExceptions
import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.springframework.security.crypto.password.PasswordEncoder
import java.io.Serializable
import java.time.OffsetDateTime

@Embeddable
data class Password(
    @Column(name = "password")
    var value: String,
) : Serializable {
    companion object {
        const val PASSWORD_EXPIRATION_DAYS = 365L
    }

    @Column(nullable = false)
    private var expirationDate = OffsetDateTime.now().plusDays(PASSWORD_EXPIRATION_DAYS)

    @Column(nullable = false)
    private var failedCount = 0

    fun updateFailedCount(isMatched: Boolean) {
        failedCount = if (isMatched) 0 else failedCount + 1

        if (isMatched) extendExpirationDate()
        if (failedCount >= 5) throw CustomExceptions.PasswordFailedExceededException()
    }

    fun changePassword(
        newPassword: String,
        oldPassword: String,
        passwordEncoder: PasswordEncoder,
    ) {
        this.value = passwordEncoder.encode(newPassword)
        extendExpirationDate()
    }

    fun isMatched(
        rawPassword: String,
        passwordEncoder: PasswordEncoder,
    ): Boolean {
        if (failedCount >= 5) throw CustomExceptions.PasswordFailedExceededException()
        val matches = passwordEncoder.matches(rawPassword, this.value)
        return matches.also {
            updateFailedCount(it)
        }
    }

    private fun extendExpirationDate() {
        this.expirationDate = OffsetDateTime.now().plusDays(PASSWORD_EXPIRATION_DAYS)
    }
}
