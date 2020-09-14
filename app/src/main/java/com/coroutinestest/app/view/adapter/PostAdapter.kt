package com.coroutinestest.app.view.adapter

import android.view.View
import com.coroutinestest.app.R
import com.coroutinestest.app.model.Post
import com.coroutinestest.app.view.viewholder.PostViewHolder
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow

class PostAdapter : BaseAdapter() {

    init {
        addSection(arrayListOf<Post>())
    }

    fun addPostList(posts: List<Post>) {
        sections().first().run {
            clear()
            addAll(posts)
            notifyDataSetChanged()
        }
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_post

    override fun viewHolder(layout: Int, view: View) = PostViewHolder(view)

}