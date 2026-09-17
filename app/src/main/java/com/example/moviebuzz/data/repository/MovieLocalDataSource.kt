package com.example.moviebuzz.data.repository

import com.example.androidarchitecture.util.Result
import com.example.moviebuzz.data.local.movies.MovieDao
import com.example.moviebuzz.data.mapper.toDomain
import com.example.moviebuzz.data.model.MovieDbData
import com.example.moviebuzz.domain.movie.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieLocalDataSource(
    private val movieDao : MovieDao
): MovieDataSource.local {
    override suspend fun getMovies(): Result<Movie> {
        return withContext(Dispatchers.IO) {
            val movie = movieDao.getMovies()

            if (movie != null) {
                Result.Success(movie.toDomain())
            } else {
                Result.Error(Exception("Data not available"))
            }
        }
    }

    override suspend fun saveMovies(movies: MovieDbData) {
        movieDao.insertMovieData(movies)

    }
}