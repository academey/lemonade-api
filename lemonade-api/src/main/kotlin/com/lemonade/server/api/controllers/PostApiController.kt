package com.lemonade.server.api.controllers

import com.lemonade.server.api.controllers.dto.ApiResponse
import com.lemonade.server.api.controllers.dto.PostDto
import com.lemonade.server.domain.post.PostService
import com.lemonade.server.domain.user.UserRepository
import com.lemonade.server.utils.CustomExceptions
import com.lemonade.server.utils.LemonadeLogger
import jakarta.validation.Valid
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/posts")
class PostApiController(
    private val postService: PostService,
    private val userRepository: UserRepository,
) {
    @GetMapping
    fun findAll(
//        @RequestParam keyword: String,
//        @RequestParam sort: SearchDto.SortingParam = SearchDto.SortingParam.accuracy,
        pageable: Pageable = PageRequest.of(1, 10),
    ): ApiResponse<List<PostDto.PostResponse>> {
        log.info("info hj test")
        log.debug("debug hj test")
        log.warn("warn hj test")
        log.error("error hj test")
        return ApiResponse.createSuccess(
            postService.findAll(
                pageable = pageable,
            ).toList().map { PostDto.PostResponse.of(it) },
        )
    }

    @PostMapping
    fun create(
        authentication: Authentication,
        @RequestBody @Valid requestDto: PostDto.CreateReq,
    ): ApiResponse<PostDto.PostResponse> {
        return ApiResponse.createSuccess(
            postService.create(
                user = userRepository.findByEmail(authentication.name) ?: throw CustomExceptions.NotFoundException(),
                title = requestDto.title,
                content = requestDto.content,
            ).let { PostDto.PostResponse.of(it) },
        )
    }

    @PutMapping("/{postId}")
    fun update(
        authentication: Authentication,
        @PathVariable postId: Long,
        @RequestBody @Valid requestDto: PostDto.UpdateReq,
    ): ApiResponse<PostDto.PostResponse> {

        return ApiResponse.createSuccess(
            postService.update(
                user = userRepository.findByEmail(authentication.name) ?: throw CustomExceptions.NotFoundException(),
                post = postService.findById(postId) ?: throw CustomExceptions.NotFoundException(),
                title = requestDto.title,
                content = requestDto.content,
            ).let { PostDto.PostResponse.of(it) },
        )
    }

    @DeleteMapping("/{postId}")
    fun delete(
        authentication: Authentication,
        @PathVariable postId: Long,
    ): ApiResponse<Unit> {
        return ApiResponse.createSuccess(
            postService.delete(
                user = userRepository.findByEmail(authentication.name) ?: throw CustomExceptions.NotFoundException(),
                post = postService.findById(postId) ?: throw CustomExceptions.NotFoundException(),
            ),
        )
    }

    companion object: LemonadeLogger()
}
