package com.example.articles.di

import com.example.articles.data.PostsRepositoryImpl
import com.example.articles.domain.repository.PostsRepository
import com.example.local.db.RedditDatabase
import com.example.remote.service.RedditApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PostModule {
    @Provides
    @Singleton
    fun providePostRepository(api: RedditApi,db:RedditDatabase):PostsRepository =
        PostsRepositoryImpl(api,db)
}