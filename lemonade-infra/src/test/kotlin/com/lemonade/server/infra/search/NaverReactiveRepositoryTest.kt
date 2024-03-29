package com.lemonade.server.infra.search

import com.lemonade.server.domain.search.Sorting
import com.lemonade.server.infra.search.naver.NaverRealtimeSearchRepository
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class NaverReactiveRepositoryTest(
    private val naverReactiveRepository: NaverRealtimeSearchRepository,
) {
    @Nested
    inner class Search() {
        @Test
        fun `When ~~ `() {
            runBlocking {
                run {
                    val blogList =
                        naverReactiveRepository.search(
                            keyword = "Test",
                            sort = Sorting.정확도순,
                            page = 1,
                            size = 10,
                        )
                    println(blogList)
                }
            }
        }
    }
}
