package com.example.articles.ui

import com.example.models.domainModels.Post

sealed class PostsScreenEvent {
    object LoadPostsList : PostsScreenEvent()
    object RefreshScreen : PostsScreenEvent()
}

data class PostsScreenViewState(
    val posts: List<Post> = emptyList(),
)