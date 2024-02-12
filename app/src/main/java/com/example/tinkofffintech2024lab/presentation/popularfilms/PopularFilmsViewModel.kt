package com.example.tinkofffintech2024lab.presentation.popularfilms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.Film
import com.example.domain.usecase.GetPopularFilmsUseCase
import com.example.domain.usecase.UpdateFilmFavouriteStatusUseCase
import kotlinx.coroutines.launch

class PopularFilmsViewModel(
    private val getPopularFilmsUseCase: GetPopularFilmsUseCase,
    private val updateFilmFavouriteStatusUseCase: UpdateFilmFavouriteStatusUseCase
) : ViewModel() {

    private val _filmsList = MutableLiveData<List<Film>>()
    val filmsList: LiveData<List<Film>> get() = _filmsList
    
    private val _updatedFilmFavouriteStatus = MutableLiveData<Boolean>()
    val updatedFilmFavouriteStatus: LiveData<Boolean> get() = _updatedFilmFavouriteStatus

    fun getPopularFilms() {
        viewModelScope.launch {
            _filmsList.value = getPopularFilmsUseCase.execute()
        }
    }

    fun updateFilmFavouriteStatus(film: Film) {
        viewModelScope.launch {
            _updatedFilmFavouriteStatus.value = updateFilmFavouriteStatusUseCase.execute(film)
        }
    }


}