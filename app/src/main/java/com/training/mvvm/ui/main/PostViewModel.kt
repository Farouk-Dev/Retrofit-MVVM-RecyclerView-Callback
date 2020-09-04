package com.training.mvvm.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.training.mvvm.data.PostClient
import com.training.mvvm.pojo.PostModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers


class PostViewModel : ViewModel() {
    var postsMutableLiveData: MutableLiveData<List<PostModel>> = MutableLiveData()

    // callback
    fun getPosts() {
        val observable: Observable<List<PostModel>>? = PostClient.getInstance()?.getPosts()
        observable?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({ posts -> postsMutableLiveData.value = posts },
                { e -> Log.d("Error :", e.toString()) })

    }
}