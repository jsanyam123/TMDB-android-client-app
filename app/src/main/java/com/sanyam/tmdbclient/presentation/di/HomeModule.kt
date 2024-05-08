package com.sanyam.tmdbclient.presentation.di

import com.sanyam.tmdbclient.domain.usecase.GetMoviesUseCase
import com.sanyam.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.sanyam.tmdbclient.domain.usecase.UpdateMoviesUsecase
import com.sanyam.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.sanyam.tmdbclient.presentation.HomeViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    fun provideHomeViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        getTvShowsUseCase: GetTvShowsUseCase,
        getUpdateMoviesUsecase: UpdateMoviesUsecase,
        getUpdateTvShowsUseCase: UpdateTvShowsUseCase
    ): HomeViewModelFactory {
        return HomeViewModelFactory(
            getMoviesUseCase, getTvShowsUseCase,getUpdateMoviesUsecase, getUpdateTvShowsUseCase
        )
    }

}