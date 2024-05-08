package com.sanyam.tmdbclient.presentation.di

import com.sanyam.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.sanyam.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.sanyam.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.sanyam.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }
}