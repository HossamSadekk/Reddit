package com.example.models.remote.postDetails


import com.google.gson.annotations.SerializedName

data class ChildData(
    @SerializedName("author")
    val author: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("num_comments")
    val numComments: Int,
    @SerializedName("permalink")
    val permalink: String,
    @SerializedName("score")
    val score: Int,
    @SerializedName("selftext")
    val selftext: String,
    @SerializedName("title")
    val title: String,
)