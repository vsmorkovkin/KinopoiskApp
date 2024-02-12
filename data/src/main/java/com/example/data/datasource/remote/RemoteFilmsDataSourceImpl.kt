package com.example.data.datasource.remote

import com.example.data.datasource.remote.model.details.FilmDetailsApiModel
import com.example.data.datasource.remote.model.popular.PopularFilmsPage

class RemoteFilmsDataSourceImpl(
    private val filmService: FilmService
) : RemoteFilmsDataSource {

    override suspend fun getPopularFilms(): PopularFilmsPage {
        return filmService.getPopularFilms()
    }

    override suspend fun getFilmInfoById(filmId: Int): FilmDetailsApiModel {
        return filmService.getFilmInfoById(filmId = filmId)
    }
}