package com.example.data.datasource.remote

import com.example.data.datasource.remote.model.FilmApiModel
import com.example.data.datasource.remote.model.PopularFilmsPage
import com.example.domain.entity.Film

class RemoteFilmsDataSourceImpl(
    private val filmService: FilmService
) : RemoteFilmsDataSource {

    override suspend fun getPopularFilms(): PopularFilmsPage {
        return filmService.getPopularFilms()
    }
}