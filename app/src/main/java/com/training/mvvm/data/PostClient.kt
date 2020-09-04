package com.training.mvvm.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostClient {
    private lateinit var postInterface: PostInterface

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        private lateinit var INSTANCE: PostClient
        fun getInstance(): PostClient {
            if (INSTANCE == null) INSTANCE = PostClient()
            return INSTANCE
        }
    }

    init {
        val retrofit: Retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        postInterface = retrofit.create(PostInterface::class.java)
    }
}