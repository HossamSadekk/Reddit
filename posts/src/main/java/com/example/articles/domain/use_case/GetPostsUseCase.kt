package com.example.articles.domain.use_case

import com.example.articles.domain.repository.PostsRepository
import com.example.models.domainModels.Post
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val postsRepository: PostsRepository) {
    operator fun invoke(): Flow<List<Post>> {
        val characters = postsRepository.getPosts()
        return characters
    }
}