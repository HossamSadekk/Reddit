package com.example.models.models

data class Article(
    val author: String,
    val title: String,
    val description: String,
    val image: String?,
    val numComments: Int,
    val score: Int,
    val url: String,

)
