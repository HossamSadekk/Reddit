package com.example.remote.service

import com.example.models.remote.PostResponse
import retrofit2.http.GET

interface RedditApi {
    @GET(POSTS)
    suspend fun getPosts(
    ): PostResponse

    companion object {
        const val BASE_URL = "https://www.reddit.com/"
        const val POSTS = "r/kotlin/.json"
    }
}