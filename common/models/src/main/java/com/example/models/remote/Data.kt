package com.example.models.remote


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("children")
    val children: List<Children>
)