// package com.lemonade.server.service
//
// import com.lemonade.server.domain.blog.Blog
// import com.lemonade.server.domain.blog.PopularSearchKeyword
// import com.lemonade.server.domain.blog.PopularSearchKeywordRepository
// import com.lemonade.server.domain.post.Post
// import com.lemonade.server.domain.post.PostRepository
// import com.lemonade.server.domain.search.DBSearchService
// import com.lemonade.server.domain.search.Sorting
// import com.lemonade.server.domain.user.Role
// import com.lemonade.server.domain.user.User
// import com.lemonade.server.utils.CustomExceptions
// import kotlinx.coroutines.Dispatchers
// import kotlinx.coroutines.launch
// import kotlinx.coroutines.runBlocking
// import org.springframework.data.domain.Page
// import org.springframework.data.domain.Pageable
// import org.springframework.stereotype.Service
// import java.time.LocalDateTime
//
// @Service
// class PostService(
//    private val postRepository: PostRepository
// ) {
//     fun findAll(
//        pageable: Pageable,
//     ): Page<Post> {
//         return postRepository.findAll(pageable)
//     }
//
//     fun create(
//         user: User,
//         title: String,
//         content: String
//     ): Post {
//         return postRepository.save(Post(
//             user = user,
//             title = title,
//             content = content
//         ))
//     }
//
//     fun update(
//         post: Post,
//         user: User,
//         title: String?,
//         content: String?
//     ): Post {
//         if (user.role != Role.ADMIN && user !=  post.user) {
//             throw CustomExceptions.NotAuthorized("Admin 이거나 글 주인이 아닙니다")
//         }
//         return postRepository.save(Post(
//             user = user,
//             title = title,
//             content = content
//         ))
//     }
// }
