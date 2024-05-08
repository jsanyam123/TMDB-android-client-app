package com.sanyam.tmdbclient.presentation

import android.app.Application
import com.sanyam.tmdbclient.BuildConfig
import com.sanyam.tmdbclient.presentation.di.AppComponent
import com.sanyam.tmdbclient.presentation.di.AppModule
import com.sanyam.tmdbclient.presentation.di.NetModule
import com.sanyam.tmdbclient.presentation.di.RemoteDataModule
import com.sanyam.tmdbclient.presentation.di.*

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }
}