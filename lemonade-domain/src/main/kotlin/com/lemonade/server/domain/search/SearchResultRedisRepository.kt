package com.lemonade.server.domain.search

interface SearchResultRedisRepository {
    fun findByKeywordAndSortingAndPageAndSize(
        keyword: String,
        sorting: Sorting,
        page: Int,
        size: Int,
    ): SearchResult
}
