package com.sanyam.tmdbclient.domain.usecase

import com.sanyam.tmdbclient.data.model.artist.Artist
import com.sanyam.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}