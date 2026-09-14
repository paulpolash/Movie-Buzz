package com.example.moviebuzz.data.repository

import com.example.androidarchitecture.util.Result
import com.example.moviebuzz.data.model.MovieDto
import com.example.moviebuzz.data.remote.MovieApiService
import com.example.moviebuzz.domain.movie.Movie

class MovieRemoteDataSource(
private val movieApiService: MovieApiService
): MovieDataSource.Remote {
    override suspend fun getMovies(): Result<MovieDto> {
        TODO("Not yet implemented")
    }

    override suspend fun saveMovies(movies: Movie): String {
        TODO("Not yet implemented")
    }
}