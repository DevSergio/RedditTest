package com.coroutinestest.app.network

import com.coroutinestest.app.model.Post
import com.skydoves.sandwich.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface RedditService {

    @GET("top.json")
    suspend fun fetchPostList(): ApiResponse<List<Post>>
}