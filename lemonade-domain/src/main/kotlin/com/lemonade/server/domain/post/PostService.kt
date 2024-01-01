package com.lemonade.server.domain.post

import com.lemonade.server.domain.user.Role
import com.lemonade.server.domain.user.User
import com.lemonade.server.utils.CustomExceptions
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository,
) {
    fun findById(id: Long): Post? {
        return postRepository.findByIdOrNull(id)
    }

    fun findAll(pageable: Pageable): Page<Post> {
        return postRepository.findAll(pageable)
    }

    fun create(
        user: User,
        title: String,
        content: String,
    ): Post {
        return postRepository.save(
            Post(
                user = user,
                title = title,
                content = content,
            ),
        )
    }

    fun update(
        post: Post,
        user: User,
        title: String?,
        content: String?,
    ): Post {
        if (user.role != Role.ADMIN && user != post.user) {
            throw CustomExceptions.UnAuthorized("Admin 이거나 글 주인이 아닙니다")
        }

        return post.also {
            if (title != null) it.title = title
            if (content != null) it.content = content
        }.let(postRepository::save)
    }

    fun delete(
        post: Post,
        user: User,
    ) {
        if (user.role != Role.ADMIN && user != post.user) {
            throw CustomExceptions.UnAuthorized("Admin 이거나 글 주인이 아닙니다")
        }
        postRepository.delete(post)
    }
}
