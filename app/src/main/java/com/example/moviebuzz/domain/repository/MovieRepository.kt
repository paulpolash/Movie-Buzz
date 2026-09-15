package com.example.moviebuzz.domain.repository

import com.example.androidarchitecture.util.Result
import com.example.moviebuzz.domain.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): Result<List<Movie>>
}