package com.example.moviebuzz.data.local.movies

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.moviebuzz.data.model.MovieDbData
import com.example.moviebuzz.data.model.current_playing.CurrentMovieDbData

@Dao
interface MovieDao {
    @Insert
    suspend fun insertMovieData(movieDbData: MovieDbData)

    @Query("SELECT * FROM movies")
    fun getMovies(): MovieDbData?

    @Query("SELECT * FROM current_movies")
    fun getCurrentMovies(): CurrentMovieDbData?
}