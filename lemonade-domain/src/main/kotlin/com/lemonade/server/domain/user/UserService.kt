package com.lemonade.server.domain.user

import com.lemonade.server.utils.CustomExceptions
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
) {
    fun findById(id: Long): User? = userRepository.findById(id).orElse(null)

    fun findByEmail(email: String): User? = userRepository.findByEmail(email)

    fun signUp(
        email: String,
        name: String,
        picture: String?,
        rawPassword: String,
    ): User {
        if (userRepository.findByEmail(email) != null) {
            throw CustomExceptions.AlreadyExistException()
        }

        return create(
            email,
            name,
            picture,
            rawPassword,
        )
    }

    fun signIn(
        email: String,
        rawPassword: String,
    ): User {
        val user: User = findByEmail(email) ?: throw CustomExceptions.NotFoundException()
        require(user.password.isMatched(rawPassword = rawPassword, passwordEncoder = passwordEncoder)) {
            throw CustomExceptions.EmailSignInFailedException()
        }

        return user
    }

    fun create(
        email: String,
        name: String,
        picture: String?,
        rawPassword: String,
    ): User =
        userRepository.save(
            User(
                email = email,
                name = name,
                picture = picture,
                role = Role.USER, // 최초 가입시 USER 로 설정
                password = Password(rawPassword.let { passwordEncoder.encode(it) }),
            ),
        )

    fun update(
        user: User,
        name: String?,
        picture: String?,
    ): User =
        userRepository.save(
            user.update(
                name,
                picture,
            ),
        )

    fun remove(userId: Long) {
        userRepository.deleteById(userId)
    }
}
