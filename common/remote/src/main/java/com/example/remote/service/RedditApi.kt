package com.example.remote.service

import com.example.models.remote.ArticlesResponse
import retrofit2.http.GET

interface RedditApi {
    @GET(ARTICLES)
    suspend fun getTopHeadlines(
    ): ArticlesResponse
    companion object {
        const val BASE_URL = "https://www.reddit.com/"
        const val ARTICLES = "r/kotlin/.json"
    }
}