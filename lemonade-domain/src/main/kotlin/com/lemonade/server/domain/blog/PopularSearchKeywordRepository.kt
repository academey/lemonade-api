package com.lemonade.server.domain.blog

interface PopularSearchKeywordRepository {
    fun get(size: Long): List<PopularSearchKeyword>

    fun update(keyword: String)
}
