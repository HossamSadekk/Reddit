package com.example.local.di

import android.content.Context
import androidx.room.Room
import com.example.local.db.RedditDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, RedditDatabase::class.java, "reddit_database")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providesPostsDao(db: RedditDatabase) =
        db.postsDao()
}