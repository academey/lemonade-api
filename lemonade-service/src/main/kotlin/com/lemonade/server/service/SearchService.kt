// package com.lemonade.server.service
//
// import com.lemonade.server.domain.blog.Blog
// import com.lemonade.server.domain.blog.PopularSearchKeyword
// import com.lemonade.server.domain.blog.PopularSearchKeywordRepository
// import com.lemonade.server.domain.search.DBSearchService
// import com.lemonade.server.domain.search.Sorting
// import kotlinx.coroutines.Dispatchers
// import kotlinx.coroutines.launch
// import kotlinx.coroutines.runBlocking
// import org.springframework.data.domain.Pageable
// import org.springframework.stereotype.Service
// import java.time.LocalDateTime
//
// @Service
// class SearchService(
//    private val popularSearchKeywordRepository: PopularSearchKeywordRepository,
//    private val dbSearchService: DBSearchService,
// ) {
//    fun search(
//        keyword: String,
//        sorting: Sorting,
//        pageable: Pageable,
//    ): List<Blog> =
//        runBlocking(Dispatchers.IO) {
//            launch {
//                println("thread name ${Thread.currentThread().name} ${LocalDateTime.now()} popularSearchKeywordRepository.update(keyword)")
//                popularSearchKeywordRepository.update(keyword)
//            }
//
//            // TODO 해당 부분을 Cachable 로 빼내고 싶었지만 object 를 serialize 하는 과정을 실패했다.
//            // 추후에는 Cachable로 AOP를 개선하자
//            val redisBlogList =
//                redisSearchService.get(
//                    keyword,
//                    sorting,
//                    pageable,
//                )
//            if (redisBlogList != null) return@runBlocking redisBlogList
//
//            val dbBlogList =
//                dbSearchService.get(
//                    keyword,
//                    sorting,
//                    pageable,
//                )
//
//            if (dbBlogList != null) {
//                launch {
//                    println("redisSearchService.update thread name ${Thread.currentThread().name} ${LocalDateTime.now()}")
//                    redisSearchService.update(
//                        keyword,
//                        sorting,
//                        pageable,
//                        dbBlogList,
//                    )
//                }
//                return@runBlocking dbBlogList
//            }
//
//            val realtimeBlogList =
//                realtimeSearchService.search(
//                    keyword,
//                    sorting,
//                    pageable,
//                )
//
//            launch {
//                println("redisSearchService.update thread name ${Thread.currentThread().name} ${LocalDateTime.now()}")
//                redisSearchService.update(
//                    keyword,
//                    sorting,
//                    pageable,
//                    realtimeBlogList,
//                )
//            }
//            launch {
//                println("dbSearchService.create thread name ${Thread.currentThread().name} ${LocalDateTime.now()}")
//                dbSearchService.create(
//                    keyword,
//                    sorting,
//                    pageable,
//                    realtimeBlogList,
//                )
//            }
//            realtimeBlogList
//        }
//
//    fun getPopularSearchKeywords(size: Long): List<PopularSearchKeyword> {
//        return popularSearchKeywordRepository.get(size)
//    }
// }
