package com.example.remote.service

import com.example.models.remote.PostResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RedditApi {
    @GET(POSTS)
    suspend fun getPosts(
    ): PostResponse
    @GET(POSTDETAILS)
    suspend fun getPostDetails(
        @Path("subreddit") subreddit: String,
        @Path("postId") postId: String
    ): PostResponse
    companion object {
        const val BASE_URL = "https://www.reddit.com/"
        const val POSTS = "r/kotlin/.json"
        const val POSTDETAILS = "r/{subreddit}/comments/{postId}/.json"
    }
}