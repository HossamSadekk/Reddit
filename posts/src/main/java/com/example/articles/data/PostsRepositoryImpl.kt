package com.example.articles.data

import com.example.articles.domain.repository.PostsRepository
import com.example.local.db.RedditDatabase
import com.example.models.domainModels.Post
import com.example.models.mapper.toArticleEntity
import com.example.models.mapper.toPostsDomain
import com.example.remote.service.RedditApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val api: RedditApi,
    private val db: RedditDatabase
) : PostsRepository {

    override fun getPosts(): Flow<List<Post>> = db.postsDao().getAllPosts().map { postChached ->
        postChached.toPostsDomain()
    }.onEach { posts ->
        if (posts.isEmpty()) {
            refreshPosts()
        }
    }

    override suspend fun refreshPosts() {
        api.getPosts().data.children.map {
            it.data.toArticleEntity()
        }.also {
            db.postsDao().insertAllPosts(it)
        }
    }
}