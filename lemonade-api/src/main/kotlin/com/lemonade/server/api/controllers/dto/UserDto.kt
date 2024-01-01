package com.lemonade.server.api.controllers.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.lemonade.server.domain.user.Role
import com.lemonade.server.domain.user.User
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.Length

object UserDto {
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
    data class SignUpReq(
        @field:Email
        @field:NotEmpty
        val email: String?,
        @field:NotEmpty
        val name: String?,
        val picture: String?,
        @field:NotEmpty
        @field:Length(min = 6)
        val password: String?,
    )

    data class UserRes(
        val id: Long,
        val email: String,
        val name: String,
        val picture: String?,
        var role: Role,
    ) {
        companion object {
            fun of(user: User) =
                UserRes(
                    id = user.id,
                    email = user.email,
                    name = user.name,
                    picture = user.picture,
                    role = user.role,
                )
        }
    }

    data class UserSimpleRes(
        val email: String,
        var role: String,
    )
}
