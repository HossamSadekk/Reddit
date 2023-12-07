package com.example.postdetails.di

import com.example.local.db.RedditDatabase
import com.example.postdetails.data.repository.PostDetailsRepositoryImpl
import com.example.postdetails.domain.repository.PostDetailsRepository
import com.example.remote.service.RedditApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PostDetailsModule {
    @Provides
    @Singleton
    fun providePostRepository(api: RedditApi, db: RedditDatabase):PostDetailsRepository =
        PostDetailsRepositoryImpl(api)
}