package com.example.moviebuzz.data.local.movies

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.moviebuzz.data.model.MovieDbData

@Dao
interface MovieDao {
    @Insert
    suspend fun insertMovieData(movieDbData: MovieDbData)

    @Query("SELECT * FROM movies")
    fun getMovies(): MovieDbData
}