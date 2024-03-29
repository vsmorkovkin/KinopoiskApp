package com.example.domain.usecase

import com.example.domain.entity.Film
import com.example.domain.repository.FilmRepository

class GetFavouriteFilmsUseCase(
    private val filmRepository: FilmRepository
) {

    suspend fun execute(): List<Film> {
        return filmRepository.getFavouriteFilms()
    }

}