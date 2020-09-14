package com.coroutinestest.app.view.ui.main

import android.os.Bundle
import com.coroutinestest.app.R
import com.coroutinestest.app.base.DatabindingActivity
import com.coroutinestest.app.databinding.ActivityHomeBinding
import com.coroutinestest.app.view.adapter.PostAdapter
import org.koin.android.viewmodel.ext.android.getViewModel


class MainActivity : DatabindingActivity() {

    private val binding: ActivityHomeBinding by binding(R.layout.activity_home)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            vm = getViewModel<MainViewModel>().apply { fetchPostList()  }
            activity = this@MainActivity
            adapter = PostAdapter()
        }
    }
}