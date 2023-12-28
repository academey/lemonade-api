package com.kakao.bank.blog.search.infra.search.kakao

import com.kakao.bank.blog.search.domain.blog.Blog
import com.kakao.bank.blog.search.domain.blog.BlogVendorType
import com.kakao.bank.blog.search.domain.search.RealtimeSearchRepository
import com.kakao.bank.blog.search.domain.search.Sorting
import com.kakao.bank.blog.search.domain.search.Sorting.*
import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Repository
class KakaoRealtimeSearchRepository(
    private val kakaoWebClient: WebClient,
) : RealtimeSearchRepository {
    enum class Sort {
        accuracy,
        recency,
        ;

        companion object {
            fun of(sort: Sorting): Sort =
                when (sort) {
                    정확도순 -> accuracy
                    최신순 -> recency
                }
        }
    }

    override suspend fun search(
        keyword: String,
        sorting: Sorting,
        page: Int,
        size: Int,
    ): List<Blog> =
        kakaoWebClient.get()
            .uri { uriBuilder ->
                uriBuilder.path("/v2/search/blog")
                    .queryParam("query", keyword)
                    .queryParam("sort", Sort.of(sorting))
                    .queryParam("page", page)
                    .queryParam("size", size)
                    .build()
            }
            .retrieve()
            .awaitBody<KakaoSearchBlogResult>()
            .getBlogs()

    override fun getPriority(): Int = BlogVendorType.Kakao.priority
}
