package com.coroutinestest.app.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.coroutinestest.app.model.Post


@Database(entities = [Post::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao
}