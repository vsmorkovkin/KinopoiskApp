package com.example.domain.entity

data class Film(
    val title: String,
    val genre: String,
    val year: Int,
    val imageUrl: String,
    val inFavourites: Boolean
)
