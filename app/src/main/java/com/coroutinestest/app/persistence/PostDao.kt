package com.coroutinestest.app.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.coroutinestest.app.model.Post

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPostList(posters: List<Post>)

    @Query("SELECT * FROM Post WHERE id = :id_")
    fun getPost(id_: Long): Post

    @Query("SELECT * FROM Post")
    suspend fun getPostList(): List<Post>
}