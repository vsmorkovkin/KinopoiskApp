package com.example.tinkofffintech2024lab.presentation.favouritefilms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.Film
import com.example.domain.usecase.GetFavouriteFilmsUseCase
import com.example.domain.usecase.UpdateFilmFavouriteStatusUseCase
import kotlinx.coroutines.launch

class FavouriteFilmsViewModel(
    private val getFavouriteFilmsUseCase: GetFavouriteFilmsUseCase,
    private val updateFilmFavouriteStatusUseCase: UpdateFilmFavouriteStatusUseCase
) : ViewModel() {

    private val _filmsList = MutableLiveData<List<Film>>()
    val filmsList: LiveData<List<Film>> get() = _filmsList

    fun getFavouriteFilms() {
        viewModelScope.launch {
            _filmsList.value = getFavouriteFilmsUseCase.execute()
        }
    }

    fun updateFavouriteFilmStatus(film: Film) {
        viewModelScope.launch {
            updateFilmFavouriteStatusUseCase.execute(film)
            _filmsList.value = getFavouriteFilmsUseCase.execute()
        }
    }

}