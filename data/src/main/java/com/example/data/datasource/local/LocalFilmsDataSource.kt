package com.example.data.datasource.local

import com.example.data.datasource.local.model.FilmEntity
import com.example.data.datasource.local.model.FilmFavouriteStatus
import com.example.domain.entity.Film

interface LocalFilmsDataSource {

    suspend fun updateFilmFavouriteStatus(film: Film): Boolean

    suspend fun getFilmFavouriteStatus(film: Film): FilmFavouriteStatus

    suspend fun getFavouriteFilms(): List<FilmEntity>

}