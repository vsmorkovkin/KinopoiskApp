package com.example.data.datasource.remote

import com.example.data.datasource.remote.model.details.FilmDetailsApiModel
import com.example.data.datasource.remote.model.popular.PopularFilmsPage

interface RemoteFilmsDataSource {

    suspend fun getPopularFilms() : PopularFilmsPage

    suspend fun getFilmInfoById(filmId: Int) : FilmDetailsApiModel

}