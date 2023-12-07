package com.example.postdetails.ui

import com.example.core.use_case.QueryPostParameter
import com.example.models.domainModels.Post

sealed class PostsDetailsScreenEvent {
    data class LoadPostDetails(val parameter: QueryPostParameter) :
        PostsDetailsScreenEvent()

    object RefreshScreen : PostsDetailsScreenEvent()
}

data class PostDetailsScreenViewState(
    val posts: Post,
)

