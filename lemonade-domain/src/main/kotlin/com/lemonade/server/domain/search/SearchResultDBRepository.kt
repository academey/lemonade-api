package com.lemonade.server.domain.search

import org.springframework.data.repository.CrudRepository

interface SearchResultDBRepository : CrudRepository<SearchResult, Long> {
    fun findByKeywordAndSortingAndPageAndSize(
        keyword: String,
        sorting: Sorting,
        page: Int,
        size: Int,
    ): SearchResult?
}
