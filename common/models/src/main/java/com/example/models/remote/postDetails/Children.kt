package com.example.models.remote.postDetails


import com.google.gson.annotations.SerializedName

data class Children(
    @SerializedName("data")
    val `data`: ChildData,
    @SerializedName("kind")
    val kind: String
)