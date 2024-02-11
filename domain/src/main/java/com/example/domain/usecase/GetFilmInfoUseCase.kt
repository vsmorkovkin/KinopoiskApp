package com.example.domain.usecase

import com.example.domain.entity.Film
import com.example.domain.entity.FilmDetails
import com.example.domain.repository.FilmRepository

class GetFilmInfoUseCase(
    private val filmRepository: FilmRepository
) {

    fun execute(film: Film): FilmDetails {
        return filmRepository.getFilmInfo(film)
    }

}