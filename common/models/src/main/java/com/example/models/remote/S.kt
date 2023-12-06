package com.example.models.remote


import com.google.gson.annotations.SerializedName

data class S(
    @SerializedName("u")
    val u: String,
    @SerializedName("x")
    val x: Int,
    @SerializedName("y")
    val y: Int
)