package com.kakao.bank.blog.search.api.controllers

import com.kakao.bank.blog.search.api.controllers.dto.ApiResponse
import com.kakao.bank.blog.search.api.controllers.dto.UserDto
import com.kakao.bank.blog.search.domain.user.UserService
import jakarta.servlet.http.HttpSession
import org.springframework.http.HttpStatus
import org.springframework.security.core.Authentication
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/users")
class UserApiController(
    private val userService: UserService,
) {
    @PostMapping("/sign-up")
    @ResponseStatus(value = HttpStatus.CREATED)
    fun signUp(
        @RequestBody
        @Validated requestDto: UserDto.SignUpReq,
    ): ApiResponse<UserDto.UserRes> =
        userService.signUp(
            requestDto.email!!,
            requestDto.name!!,
            requestDto.picture,
            requestDto.password!!,
        ).let(UserDto.UserRes::of).let { ApiResponse.createSuccess(it) }

    @GetMapping("/sign-in")
    fun signIn(authentication: Authentication): ApiResponse<UserDto.UserSimpleRes> {
        return UserDto.UserSimpleRes(
            email = authentication.name,
            role = authentication.authorities.toList()[0].authority,
        ).let { ApiResponse.createSuccess(it) }
    }

    @DeleteMapping("/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun logout(session: HttpSession) {
        session.invalidate()
    }
}
