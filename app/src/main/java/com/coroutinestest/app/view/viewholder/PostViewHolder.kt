package com.coroutinestest.app.view.viewholder

import android.view.View
import androidx.core.view.ViewCompat
import com.coroutinestest.app.databinding.ItemPostBinding
import com.coroutinestest.app.model.Post
import com.skydoves.baserecyclerviewadapter.BaseViewHolder
import timber.log.Timber

class PostViewHolder(view: View) : BaseViewHolder(view) {

    private lateinit var data: Post
    private val binding: ItemPostBinding by bindings(view)

    override fun bindData(data: Any) {
        if (data is Post) {
            this.data = data
            drawItemUI()
        }
    }

    private fun drawItemUI() {
        binding.apply {
            ViewCompat.setTransitionName(binding.itemContainer, data.title)
            post = data
            executePendingBindings()
        }
    }

    override fun onClick(p0: View?) {
        Timber.d("")
    }

    override fun onLongClick(p0: View?) = false
}