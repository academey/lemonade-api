package com.lemonade.server.api.controllers.dto

import com.lemonade.server.domain.post.Post

object PostDto {
    data class CreateReq(
        val title: String,
        val content: String,
    )

    data class UpdateReq(
        val title: String?,
        val content: String?,
    )

    data class PostResponse(
        val id: Long,
        val title: String,
        val content: String,
        val user: UserDto.UserRes,
    ) {
        companion object {
            fun of(post: Post) =
                PostResponse(
                    id = post.id,
                    title = post.title,
                    content = post.content,
                    user = post.user.let(UserDto.UserRes::of),
                )
        }
    }
}
