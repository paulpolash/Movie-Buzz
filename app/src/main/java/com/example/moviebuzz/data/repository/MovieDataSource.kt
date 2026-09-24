package com.example.moviebuzz.data.repository

import com.example.androidarchitecture.util.Result
import com.example.moviebuzz.data.model.MovieDbData
import com.example.moviebuzz.data.model.MovieDto
import com.example.moviebuzz.domain.movie.Movie

interface MovieDataSource {

    interface Remote{
        suspend fun getMovies(): Result<MovieDto>
        suspend fun saveMovies(movies: Movie): String
        suspend fun getCurrentMovies(): Result<Movie>
    }

    interface local{
        suspend fun getMovies(): Result<Movie>
        suspend fun saveMovies(movies: MovieDbData)
    }
}