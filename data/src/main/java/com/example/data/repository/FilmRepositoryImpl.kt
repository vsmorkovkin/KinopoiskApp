package com.example.data.repository

import com.example.data.datasource.local.LocalFilmsDataSource
import com.example.data.datasource.local.model.FilmEntity
import com.example.data.datasource.remote.RemoteFilmsDataSource
import com.example.domain.entity.Film
import com.example.domain.entity.FilmDetails
import com.example.domain.entity.SearchByIdParam
import com.example.domain.entity.SearchParam
import com.example.domain.repository.FilmRepository
import java.util.Locale

class FilmRepositoryImpl(
    private val remoteFilmsDataSource: RemoteFilmsDataSource,
    private val localFilmsDataSource: LocalFilmsDataSource
) : FilmRepository{

    override suspend fun getPopularFilms(): List<Film> {
        val popularFilmsPage = remoteFilmsDataSource.getPopularFilms()

        return popularFilmsPage.films.map { filmApiModel ->
            val film = Film(
                id = filmApiModel.filmId,
                title = filmApiModel.nameRu ?: filmApiModel.nameEn,
                genre = filmApiModel.genres[0].genre.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.ROOT
                    ) else it.toString()
                },
                year = filmApiModel.year.toInt(),
                imageUrl = filmApiModel.posterUrlPreview
            )
            film.inFavourites = localFilmsDataSource.getFilmFavouriteStatus(film).status
            film
        }
    }

    override suspend fun updateFavouriteStatus(film: Film): Boolean {
        localFilmsDataSource.updateFilmFavouriteStatus(film)
        return true
    }

    override suspend fun getFilmInfo(searchByIdParam: SearchByIdParam): FilmDetails {
        val filmInfo = remoteFilmsDataSource.getFilmInfoById(searchByIdParam.filmId)

        return FilmDetails(
            title = filmInfo.nameRu ?: filmInfo.nameEn ?: filmInfo.nameOriginal,
            description = filmInfo.description ?: filmInfo.shortDescription,
            countries = filmInfo.countries.map { countryApiModel -> countryApiModel.country },
            genres = filmInfo.genres.map { genresApiModel -> genresApiModel.genre },
            imageUrl = filmInfo.posterUrl
        )
    }

    override fun getFilmsByKeyword(searchParam: SearchParam): List<Film> {
        TODO("Not yet implemented")
    }

    override suspend fun getFavouriteFilms(): List<Film> {
        return localFilmsDataSource.getFavouriteFilms().map { filmEntity: FilmEntity ->
            val film = Film(
                id = filmEntity.filmId,
                title = filmEntity.title,
                genre = filmEntity.genre,
                year = filmEntity.year,
                imageUrl = filmEntity.imageUrl
            )
            film.inFavourites = true
            film
        }
    }
}