package com.lemonade.server.domain.post

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface PostRepository : CrudRepository<Post, Long> {
    fun findAllByUserId(
        userId: Long,
        pageable: Pageable,
    ): Page<Post>

    fun findAll(pageable: Pageable): Page<Post>
}
