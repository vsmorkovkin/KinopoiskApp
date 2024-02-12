package com.example.data.repository

import com.example.data.datasource.local.LocalFilmsDataSource
import com.example.data.datasource.remote.RemoteFilmsDataSource
import com.example.domain.entity.Film
import com.example.domain.entity.FilmDetails
import com.example.domain.entity.SearchParam
import com.example.domain.repository.FilmRepository

class FilmRepositoryImpl(
    private val remoteFilmsDataSource: RemoteFilmsDataSource,
    private val localFilmsDataSource: LocalFilmsDataSource
) : FilmRepository{

    override suspend fun getPopularFilms(): List<Film> {
        val popularFilmsPage = remoteFilmsDataSource.getPopularFilms()

        return popularFilmsPage.films.map { filmApiModel ->  Film(
            title = filmApiModel.nameRu ?: filmApiModel.nameEn,
            genre = filmApiModel.genres[0].genre,
            year = filmApiModel.year.toInt(),
            imageUrl = "imageUrl",
            inFavourites = false
        ) }
    }

    override fun updateFavouriteStatus(film: Film): Boolean {
        TODO("Not yet implemented")
    }

    override fun getFilmInfo(film: Film): FilmDetails {
        TODO("Not yet implemented")
    }

    override fun getFilmsByKeyword(searchParam: SearchParam): List<Film> {
        TODO("Not yet implemented")
    }

    override fun getFavouriteFilms(): List<Film> {
        TODO("Not yet implemented")
    }
}