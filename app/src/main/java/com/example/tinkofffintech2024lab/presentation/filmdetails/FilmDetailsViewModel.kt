package com.example.tinkofffintech2024lab.presentation.filmdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.SearchByIdParam
import com.example.domain.usecase.GetFilmInfoUseCase
import kotlinx.coroutines.launch
import java.lang.StringBuilder

class FilmDetailsViewModel(
    private val getFilmInfoUseCase: GetFilmInfoUseCase
) : ViewModel() {

    private val _filmImageUrl = MutableLiveData<String>()
    val filmImageUrl: LiveData<String> get() = _filmImageUrl

    private val _filmTitle = MutableLiveData<String>()
    val filmTitle: LiveData<String> get() = _filmTitle
    
    private val _filmDescription = MutableLiveData<String>()
    val filmDescription: LiveData<String> get() = _filmDescription

    private val _filmGenres = MutableLiveData<List<String>>()
    val filmGenres: LiveData<List<String>> get() = _filmGenres

    private val _filmCountries = MutableLiveData<List<String>>()
    val filmCountries: LiveData<List<String>> get() = _filmCountries
    
    fun getFilmInfo(filmId: Int) {
        viewModelScope.launch {
            val filmInfo = getFilmInfoUseCase.execute(SearchByIdParam(filmId = filmId))

            _filmImageUrl.value = filmInfo.imageUrl
            _filmTitle.value = filmInfo.title
            _filmDescription.value = filmInfo.description
            _filmGenres.value = filmInfo.genres
            _filmCountries.value = filmInfo.countries
        }
    }

    fun listToString(list: List<String>): String {
        val sb = StringBuilder()
        for (i in 0 until list.size - 1) {
            sb.append(list[i])
            sb.append(", ")
        }
        sb.append(list.last())
        return sb.toString()
    }

}