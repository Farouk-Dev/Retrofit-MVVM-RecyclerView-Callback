package com.training.mvvm.data

import android.util.Log
import com.training.mvvm.pojo.PostModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private lateinit var postInterface: PostInterface

class PostClient {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        private var INSTANCE: PostClient? = null
        fun getInstance(): PostClient? {
            if (INSTANCE == null)
                INSTANCE = PostClient()
            return INSTANCE
        }
    }

    init {
        val retrofit: Retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        postInterface = retrofit.create(PostInterface::class.java)
    }

    fun getPosts(): Call<List<PostModel>> {
        return postInterface.getPost()
    }

}



