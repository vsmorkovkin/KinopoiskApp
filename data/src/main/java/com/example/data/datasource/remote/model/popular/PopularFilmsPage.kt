package com.example.data.datasource.remote.model.popular

data class PopularFilmsPage(
    val pageCount: Int,
    val films: List<FilmApiModel>
)