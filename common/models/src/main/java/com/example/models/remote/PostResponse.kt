package com.example.models.remote


import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("kind")
    val kind: String
)