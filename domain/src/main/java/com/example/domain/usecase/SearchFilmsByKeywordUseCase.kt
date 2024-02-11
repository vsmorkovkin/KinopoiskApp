package com.example.domain.usecase

import com.example.domain.entity.Film
import com.example.domain.entity.SearchParam
import com.example.domain.repository.FilmRepository

class SearchFilmsByKeywordUseCase(
    private val filmRepository: FilmRepository
) {

    fun execute(searchParam: SearchParam): List<Film> {
        return filmRepository.getFilmsByKeyword(searchParam)
    }

}