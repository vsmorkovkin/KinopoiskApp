package com.example.data.datasource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.datasource.local.model.FilmEntity

@Dao
interface FilmDao {

    @Insert
    suspend fun insert(filmEntity: FilmEntity)

    @Update
    suspend fun update(filmEntity: FilmEntity)

    @Delete
    suspend fun delete(filmEntity: FilmEntity)

    @Query("SELECT * FROM films WHERE filmId = :filmId")
    suspend fun getFilmById(filmId: Int): FilmEntity?

    @Query("SELECT * FROM films")
    suspend fun getAllFavouriteFilms(): List<FilmEntity>

}