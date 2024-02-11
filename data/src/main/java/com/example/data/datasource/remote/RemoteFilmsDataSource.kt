package com.example.data.datasource.remote

import com.example.data.datasource.remote.model.FilmApiModel
import com.example.data.datasource.remote.model.PopularFilmsPage
import com.example.domain.entity.Film

interface RemoteFilmsDataSource {

    suspend fun getPopularFilms() : PopularFilmsPage

}