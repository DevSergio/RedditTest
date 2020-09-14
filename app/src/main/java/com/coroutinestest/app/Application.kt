package com.coroutinestest.app

import android.app.Application
import com.coroutinestest.app.di.networkModule
import com.coroutinestest.app.di.persistenceModule
import com.coroutinestest.app.di.repositoryModule
import com.coroutinestest.app.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class RedditApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@RedditApplication)
            modules(networkModule)
            modules(persistenceModule)
            modules(repositoryModule)
            modules(viewModelModule)
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}