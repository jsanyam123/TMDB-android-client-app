package com.sanyam.tmdbclient.presentation.di

import com.sanyam.tmdbclient.presentation.HomeActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
AppModule::class,
NetModule::class,
DataBaseModule::class,
UseCaseModule::class,
RepositoryModule::class,
RemoteDataModule::class,
LocalDataModule::class,
CacheDataModule::class,
HomeModule::class
])
interface AppComponent {
    fun inject(home: HomeActivity)
}