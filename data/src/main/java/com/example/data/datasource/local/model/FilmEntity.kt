package com.example.data.datasource.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "films")
data class FilmEntity(
    @PrimaryKey(autoGenerate = false)
    val filmId: Int,

    val title: String,
    val genre: String,
    val year: Int,
    val imageUrl: String
)
