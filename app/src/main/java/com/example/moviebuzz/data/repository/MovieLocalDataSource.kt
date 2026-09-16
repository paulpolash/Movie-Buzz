package com.example.moviebuzz.data.repository

import com.example.androidarchitecture.util.Result
import com.example.moviebuzz.data.local.movies.MovieDao
import com.example.moviebuzz.data.model.MovieDbData
import com.example.moviebuzz.domain.movie.Movie

class MovieLocalDataSource(
    private val movieDao : MovieDao
): MovieDataSource.local {
    override suspend fun getMovies(): Result<Movie> {
        TODO("Not yet implemented")
    }

    override suspend fun saveMovies(movies: MovieDbData) {
        movieDao.insertMovieData(movies)

    }
}