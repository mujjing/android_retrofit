package com.example.kotlin_jasonparsing_retrofit.repository

import com.example.kotlin_jasonparsing_retrofit.api.RetrofitInstance
import com.example.kotlin_jasonparsing_retrofit.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}