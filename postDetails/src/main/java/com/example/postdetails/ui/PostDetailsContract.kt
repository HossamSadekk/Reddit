package com.example.postdetails.ui

import com.example.models.domainModels.Post

sealed class PostsDetailsScreenEvent {
    object LoadPostDetails : PostsDetailsScreenEvent()
    object RefreshScreen : PostsDetailsScreenEvent()
}

data class PostDetailsScreenViewState(
    val posts: Post,
)