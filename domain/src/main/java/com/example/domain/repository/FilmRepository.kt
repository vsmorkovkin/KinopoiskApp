package com.example.domain.repository

import com.example.domain.entity.Film
import com.example.domain.entity.FilmDetails
import com.example.domain.entity.SearchByIdParam
import com.example.domain.entity.SearchParam

interface FilmRepository {

    suspend fun getPopularFilms(): List<Film>

    suspend fun updateFavouriteStatus(film: Film): Boolean

    suspend fun getFilmInfo(searchByIdParam: SearchByIdParam): FilmDetails

    fun getFilmsByKeyword(searchParam: SearchParam): List<Film>

    suspend fun getFavouriteFilms(): List<Film>

}