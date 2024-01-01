package com.lemonade.server.infra.search

import com.lemonade.server.domain.blog.Blog
import com.lemonade.server.domain.blog.BlogVendorType
import com.lemonade.server.domain.search.Sorting
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class RedisSearchRepositoryImplTest(
    private val redisSearchRepositoryImpl: RedisSearchRepositoryImpl,
) {
    @Nested
    inner class Get() {
        @Test
        fun `When ~~ `() {
            val result =
                redisSearchRepositoryImpl.get(
                    keyword = "Test",
                    sorting = Sorting.최신순,
                    size = 3,
                    page = 3,
                )
            println(result)
        }
    }

    @Nested
    inner class Update() {
        @Test
        fun `When ~~ `() {
            val blogList =
                listOf(
                    Blog(
                        title = "title",
                        contents = "contents",
                        url = "url",
                        blogName = "blogName",
                        datetime = "datetime",
                        blogVendorType = BlogVendorType.Kakao,
                    ),
                )
            val result =
                redisSearchRepositoryImpl.update(
                    keyword = "Test",
                    sorting = Sorting.최신순,
                    size = 3,
                    page = 3,
                    blogList = blogList,
                )
        }
    }
}
