package com.example.domain.usecase

import com.example.domain.entity.FilmDetails
import com.example.domain.entity.SearchByIdParam
import com.example.domain.repository.FilmRepository

class GetFilmInfoUseCase(
    private val filmRepository: FilmRepository
) {

    suspend fun execute(film: SearchByIdParam): FilmDetails {
        return filmRepository.getFilmInfo(film)
    }

}