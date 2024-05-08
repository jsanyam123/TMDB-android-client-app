package com.sanyam.tmdbclient.data.repository.artist.datasource

import com.sanyam.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
   suspend fun getArtists(): Response<ArtistList>
}