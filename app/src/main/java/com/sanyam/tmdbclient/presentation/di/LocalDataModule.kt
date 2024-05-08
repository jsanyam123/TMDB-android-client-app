package com.sanyam.tmdbclient.presentation.di

import com.sanyam.tmdbclient.data.db.MovieDao
import com.sanyam.tmdbclient.data.db.TvShowDao
import com.sanyam.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.sanyam.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.sanyam.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.sanyam.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao):TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

}