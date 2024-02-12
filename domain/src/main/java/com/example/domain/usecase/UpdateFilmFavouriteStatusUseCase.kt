package com.example.domain.usecase

import com.example.domain.entity.Film
import com.example.domain.repository.FilmRepository

class UpdateFilmFavouriteStatusUseCase(
    private val filmRepository: FilmRepository
) {

    suspend fun execute(film: Film): Boolean {
        return filmRepository.updateFavouriteStatus(film)
    }

}