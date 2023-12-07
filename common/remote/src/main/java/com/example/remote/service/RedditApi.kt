package com.example.remote.service

import com.example.models.remote.PostResponse
import com.example.models.remote.postDetails.PostDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RedditApi {
    @GET(POSTS)
    suspend fun getPosts(
    ): PostResponse
    @GET(POSTDETAILS)
    suspend fun getPostDetails(
        @Path("title") subreddit: String,
        @Path("id") postId: String
    ): PostDetailsResponse
    companion object {
        const val BASE_URL = "https://www.reddit.com/"
        const val POSTS = "r/kotlin/.json"
        const val POSTDETAILS = "r/Kotlin/comments/{id}/{title}/.json"
    }
}