package com.sanyam.tmdbclient.presentation.di.tvshow

import com.sanyam.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.sanyam.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.sanyam.tmdbclient.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }

}