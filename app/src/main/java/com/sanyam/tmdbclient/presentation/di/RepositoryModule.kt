package com.sanyam.tmdbclient.presentation.di

import com.sanyam.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.sanyam.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.sanyam.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.sanyam.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.sanyam.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import com.sanyam.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.sanyam.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.sanyam.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.sanyam.tmdbclient.domain.repository.MovieRepository
import com.sanyam.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {

        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )


    }

}