package com.coroutinestest.app.di

import com.coroutinestest.app.view.ui.detail.DetailViewModel
import com.coroutinestest.app.view.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainViewModel(get()) }

   // viewModel { DetailViewModel(get()) }
}