package com.example.domain.entity

data class Film(
    val id: Int,
    val title: String,
    val genre: String,
    val year: Int,
    val imageUrl: String,
) {
    var inFavourites: Boolean = false
}
