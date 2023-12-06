package com.example.models.remote


import com.google.gson.annotations.SerializedName

data class P(
    @SerializedName("u")
    val u: String,
    @SerializedName("x")
    val x: Int,
    @SerializedName("y")
    val y: Int
)