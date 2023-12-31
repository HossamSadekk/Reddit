package com.example.models.remote


import com.google.gson.annotations.SerializedName

data class DataX(

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

    @SerializedName("url")
    val url: String,

    )