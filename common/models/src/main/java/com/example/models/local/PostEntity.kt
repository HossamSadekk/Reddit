package com.example.models.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class PostEntity(
    @PrimaryKey
    val id:String,
    val author: String,
    val title: String,
    val description: String,
    val image: String?,
    val numComments: Int,
    val score: Int,
    val url: String,
)
