package com.example.kotlin_jasonparsing_retrofit.api

import com.example.kotlin_jasonparsing_retrofit.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost():Response<Post>

}