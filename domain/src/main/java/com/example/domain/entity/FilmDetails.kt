package com.example.domain.entity

data class FilmDetails(
    val title: String,
    val description: String,
    val genres: List<String>,
    val countries: List<String>,
    val imageUrl: String
)
