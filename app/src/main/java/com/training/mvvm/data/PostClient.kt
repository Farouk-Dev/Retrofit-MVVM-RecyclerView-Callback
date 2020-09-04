package com.training.mvvm.data

import com.training.mvvm.pojo.PostModel
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Observable
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
            Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
        postInterface = retrofit.create(PostInterface::class.java)
    }

    fun getPosts(): Observable<List<PostModel>> {
        return postInterface.getPost()
    }

}



