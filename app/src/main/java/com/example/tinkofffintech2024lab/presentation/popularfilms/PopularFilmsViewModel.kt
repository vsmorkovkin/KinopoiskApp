package com.example.tinkofffintech2024lab.presentation.popularfilms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.Film
import com.example.domain.usecase.GetPopularFilmsUseCase
import kotlinx.coroutines.launch

class PopularFilmsViewModel(
    private val getPopularFilmsUseCase: GetPopularFilmsUseCase
) : ViewModel() {

    private val _filmsList = MutableLiveData<List<Film>>()
    val filmsList: LiveData<List<Film>> get() = _filmsList

    fun getPopularFilms() {
        viewModelScope.launch {
            _filmsList.value = getPopularFilmsUseCase.execute()
        }
    }


}