package com.training.mvvm.data

import com.training.mvvm.pojo.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface PostInterface {
    @GET("posts")
    fun getPost(): Call<List<PostModel>>
}