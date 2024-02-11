package com.example.domain.usecase

import com.example.domain.entity.Film
import com.example.domain.repository.FilmRepository

class GetPopularFilmsUseCase(
    private val filmRepository: FilmRepository
) {

    fun execute(): List<Film> {
        return filmRepository.getPopularFilms()
    }

}