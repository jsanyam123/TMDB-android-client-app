package com.sanyam.tmdbclient.presentation.di.artist

import com.sanyam.tmdbclient.domain.usecase.GetArtistsUseCase
import com.sanyam.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.sanyam.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }

}