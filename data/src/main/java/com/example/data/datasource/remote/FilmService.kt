package com.example.data.datasource.remote

import com.example.data.datasource.remote.model.details.FilmDetailsApiModel
import com.example.data.datasource.remote.model.popular.PopularFilmsPage
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


interface FilmService {

    private companion object {
        private const val QUERY_PARAM_TYPE = "type"
        private const val QUERY_PARAM_PAGE = "page"
        private const val API_KEY = "e30ffed0-76ab-4dd6-b41f-4c9da2b2735b"
        private const val TOP_100_FILTER = "TOP_100_POPULAR_FILMS"
    }

    @Headers("X-API-KEY: $API_KEY")
    @GET("v2.2/films/top")
    suspend fun getPopularFilms(
        @Query(QUERY_PARAM_TYPE) type: String = TOP_100_FILTER,
        @Query(QUERY_PARAM_PAGE) page: Int = 1
    ): PopularFilmsPage

    @Headers("X-API-KEY: $API_KEY")
    @GET("v2.2/films/{filmId}")
    suspend fun getFilmInfoById(
        @Path("filmId") filmId: Int
    ) : FilmDetailsApiModel

}