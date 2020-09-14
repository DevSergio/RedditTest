package com.coroutinestest.app.repository

import androidx.annotation.WorkerThread
import com.coroutinestest.app.model.Post
import com.coroutinestest.app.network.RedditService
import com.coroutinestest.app.persistence.PostDao
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import com.skydoves.whatif.whatIfNotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber

class MainRepository constructor(
    private val redditService: RedditService,
    private val posterDao: PostDao
) : Repository {

    init {
        Timber.d("Injection MainRepository")
    }

    @WorkerThread
    suspend fun loadPosts(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        val posters: List<Post> = posterDao.getPostList()
        if (posters.isEmpty()) {
            redditService.fetchPostList().apply {
                this.suspendOnSuccess {
                    data.whatIfNotNull {
                        posterDao.insertPostList(it)
                        emit(it)
                        onSuccess()
                    }
                }
                    .onError {
                        onError(message())
                    }
                    .onException {
                        onError(message())
                    }
            }
        } else {
            emit(posters)
            onSuccess()
        }
    }.flowOn(Dispatchers.IO)
}
