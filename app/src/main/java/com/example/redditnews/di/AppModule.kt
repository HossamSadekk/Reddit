package com.example.redditnews.di

import android.content.Context
import com.example.core.connection.AndroidConnectivityChecker
import com.example.core.connection.ConnectivityChecker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideConnectivityChecker(@ApplicationContext context: Context): ConnectivityChecker {
        return AndroidConnectivityChecker(context)
    }
}