package com.example.data.datasource.remote.model

data class PopularFilmsPage(
    val pageCount: Int,
    val films: List<FilmApiModel>
)