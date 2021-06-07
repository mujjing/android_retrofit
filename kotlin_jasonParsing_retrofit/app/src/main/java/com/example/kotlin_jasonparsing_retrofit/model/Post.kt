package com.example.kotlin_jasonparsing_retrofit.model


import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)