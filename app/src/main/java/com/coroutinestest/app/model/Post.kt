package com.coroutinestest.app.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Post(
    @PrimaryKey val id: Long,
    val title: String,
    val author: String,
    val date: String,
    val image: String,
    val comments: Int
) : Parcelable