package com.coroutinestest.app.view.ui.main

import androidx.annotation.MainThread
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import com.coroutinestest.app.base.LiveCoroutinesViewModel
import com.coroutinestest.app.model.Post
import com.coroutinestest.app.repository.MainRepository
import timber.log.Timber

class MainViewModel constructor(private val mainRepository: MainRepository) :
    LiveCoroutinesViewModel() {

    var postFetchingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val postListLiveData: LiveData<List<Post>>

    private val isLoading: ObservableBoolean = ObservableBoolean(false)
    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        Timber.d("injection MainViewModel")

        postListLiveData = postFetchingLiveData.switchMap {
            isLoading.set(true)
            launchOnViewModelScope {
                this.mainRepository.loadPosts(
                    onSuccess = { isLoading.set(false) },
                    onError = { toastLiveData.postValue(it) }
                ).asLiveData()
            }
        }
    }

    @MainThread
    fun fetchPostList() {
        postFetchingLiveData.value = true
    }
}