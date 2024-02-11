package com.example.domain.repository

import com.example.domain.entity.Film
import com.example.domain.entity.FilmDetails
import com.example.domain.entity.SearchParam

interface FilmRepository {

    suspend fun getPopularFilms(): List<Film>

    fun updateFavouriteStatus(film: Film): Boolean

    fun getFilmInfo(film: Film): FilmDetails

    fun getFilmsByKeyword(searchParam: SearchParam): List<Film>

    fun getFavouriteFilms(): List<Film>

}