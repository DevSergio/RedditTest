package com.coroutinestest.app.di

import com.coroutinestest.app.repository.DetailRepository
import com.coroutinestest.app.repository.MainRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { MainRepository(get(), get()) }

   // single { DetailRepository(get()) }
}