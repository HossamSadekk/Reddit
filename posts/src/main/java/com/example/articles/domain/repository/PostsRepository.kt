package com.example.articles.domain.repository

import com.example.models.domainModels.Post
import kotlinx.coroutines.flow.Flow

interface PostsRepository {
    fun getPosts(): Flow<List<Post>>

    suspend fun refreshPosts()
}