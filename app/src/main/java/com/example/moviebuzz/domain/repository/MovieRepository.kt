package com.example.moviebuzz.domain.repository

import com.example.androidarchitecture.util.Result
import com.example.moviebuzz.domain.movie.CurrentMovie
import com.example.moviebuzz.domain.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): Result<Movie>
    suspend fun getCurrentMovies(): Result<CurrentMovie>
}