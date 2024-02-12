package com.example.data.datasource.local

import com.example.data.datasource.local.model.FilmEntity
import com.example.data.datasource.local.model.FilmFavouriteStatus
import com.example.domain.entity.Film

class LocalFilmsDataSourceImpl(
    private val filmDao: FilmDao
) : LocalFilmsDataSource {

    override suspend fun updateFilmFavouriteStatus(film: Film): Boolean {
        val filmById = filmDao.getFilmById(film.id)
        val filmEntity = FilmEntity(
            filmId = film.id,
            title = film.title,
            genre = film.genre,
            imageUrl = film.imageUrl,
            year = film.year
        )

        if (filmById == null) {
            filmDao.insert(filmEntity)
        } else {
            filmDao.delete(filmEntity)
        }

        return true
    }

    override suspend fun getFilmFavouriteStatus(film: Film): FilmFavouriteStatus {
        val filmById = filmDao.getFilmById(film.id)

        return FilmFavouriteStatus(
            filmById != null
        )
    }

    override suspend fun getFavouriteFilms(): List<FilmEntity> {
        return filmDao.getAllFavouriteFilms()
    }
}