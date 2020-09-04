package com.training.mvvm.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.training.mvvm.data.PostClient
import com.training.mvvm.pojo.PostModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostViewModel : ViewModel() {
    var postsMutableLiveData: MutableLiveData<List<PostModel>> = MutableLiveData()

    // callback
    fun getPosts() {
        PostClient.getInstance()?.getPosts()
            ?.enqueue(object : Callback<List<PostModel>> {
                override fun onResponse(
                    call: Call<List<PostModel>>,
                    response: Response<List<PostModel>>
                ) {
                    postsMutableLiveData.value = response.body()
                }

                override fun onFailure(
                    call: Call<List<PostModel>>,
                    t: Throwable?
                ) {
                }
            })
    }
}