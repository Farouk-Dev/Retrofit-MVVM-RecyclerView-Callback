package com.training.mvvm.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.training.mvvm.pojo.PostModel

class PostViewModel : ViewModel() {
    var postsMutableLiveData: MutableLiveData<List<PostModel>> = MutableLiveData()
    fun getPosts() {}
}