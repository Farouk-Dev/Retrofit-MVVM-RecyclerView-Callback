package com.training.mvvm.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.training.mvvm.data.PostClient
import com.training.mvvm.pojo.PostModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class PostViewModel : ViewModel() {
    var postsMutableLiveData: MutableLiveData<List<PostModel>> = MutableLiveData()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    // callback
    fun getPosts() {
        val observable: Observable<List<PostModel>>? = PostClient.getInstance()?.getPosts()
        compositeDisposable.add(
            observable?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({ posts -> postsMutableLiveData.value = posts },
                    { e -> Log.d("Error :", e.toString()) })
        )

    }

    /**
     * This method will be called when this ViewModel is no longer used and will be destroyed.
     *
     *
     * It is useful when ViewModel observes some data and you need to clear this subscription to
     * prevent a leak of this ViewModel.
     */
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}