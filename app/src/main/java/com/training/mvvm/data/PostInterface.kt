package com.training.mvvm.data

import com.training.mvvm.pojo.PostModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface PostInterface {
    @GET("posts")
    fun getPost(): Observable<List<PostModel>>
}