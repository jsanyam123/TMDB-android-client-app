package com.sanyam.tmdbclient.data.repository.artist.datasourceImpl

import com.sanyam.tmdbclient.data.api.TMDBService
import com.sanyam.tmdbclient.data.model.artist.ArtistList
import com.sanyam.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): ArtistRemoteDatasource {
    override suspend fun getArtists()
            : Response<ArtistList> = tmdbService.getPopularArtists(apiKey)

}

