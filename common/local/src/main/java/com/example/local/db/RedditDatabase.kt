package com.example.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.local.dao.PostsDao
import com.example.models.local.PostEntity

@Database(
    entities = [PostEntity::class],
    version = 1
)
abstract class RedditDatabase : RoomDatabase() {
    abstract fun postsDao(): PostsDao

}