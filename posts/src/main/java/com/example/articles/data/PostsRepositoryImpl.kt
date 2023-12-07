package com.example.articles.data

import com.example.articles.domain.repository.PostsRepository
import com.example.local.db.RedditDatabase
import com.example.models.domainModels.Post
import com.example.models.mapper.toArticleEntity
import com.example.models.mapper.toPostsDomain
import com.example.remote.service.RedditApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val api: RedditApi,
    private val db: RedditDatabase
) : PostsRepository {

    /* override fun getPosts(): Flow<List<Post>> = db.postsDao().getAllPosts().map { postChached ->
         postChached.toPostsDomain()
     }.onEach { posts ->
         if (posts.isEmpty()) {
             refreshPosts()
         }
     }*/
    private val _forceRefresh = MutableStateFlow(false)
    val forceRefresh: StateFlow<Boolean> = _forceRefresh
    override fun getPosts(): Flow<List<Post>> = combine(
        db.postsDao().getAllPosts(),
        forceRefresh
    ) { postChached, forceRefresh ->
        Pair(postChached.toPostsDomain(), forceRefresh)
    }.flatMapLatest { (posts, forceRefresh) ->
        if (posts.isEmpty() || forceRefresh) {
            flow {
                getFromApi().toPostsDomain()
            }
        } else {
            flowOf(posts)
        }
    }.onCompletion {
        // You can perform some initialization or loading action here
    }.onEach {
        _forceRefresh.value = false
    }

    private suspend fun getFromApi() =
        api.getPosts().data.children.map {
            it.data.toArticleEntity()
        }.also {
            db.postsDao().insertAllPosts(it)
        }.onEach {
            _forceRefresh.value = false
        }

    override suspend fun refreshPosts() {
        _forceRefresh.value = true
    }
}