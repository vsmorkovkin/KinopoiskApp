package com.example.data.datasource.remote.model.popular

import com.example.data.datasource.remote.model.base.CountryApiModel
import com.example.data.datasource.remote.model.base.GenreApiModel

data class FilmApiModel(
    val countries: List<CountryApiModel>,
    val filmId: Int,
    val filmLength: String,
    val genres: List<GenreApiModel>,
    val nameEn: String,
    val nameRu: String?,
    val posterUrl: String,
    val posterUrlPreview: String,
    val rating: String,
    val ratingChange: Any,
    val ratingVoteCount: Int,
    val year: String,
)
