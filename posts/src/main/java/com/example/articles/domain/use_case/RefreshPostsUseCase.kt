package com.example.articles.domain.use_case

import com.example.articles.domain.repository.PostsRepository
import javax.inject.Inject

class RefreshPostsUseCase@Inject constructor(
    private val postsRepository: PostsRepository
) {

    suspend operator fun invoke() {
        postsRepository.refreshPosts()
    }
}