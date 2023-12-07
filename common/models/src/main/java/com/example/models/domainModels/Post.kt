package com.example.models.domainModels

data class Post(
    val author: String,
    val title: String,
    val description: String,
    val image: String?,
    val numComments: Int,
    val score: Int,
    val url: String,

)
