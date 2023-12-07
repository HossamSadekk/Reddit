package com.example.models.remote.postDetails


import com.google.gson.annotations.SerializedName

data class PostDetailsResponseItem(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("kind")
    val kind: String
)