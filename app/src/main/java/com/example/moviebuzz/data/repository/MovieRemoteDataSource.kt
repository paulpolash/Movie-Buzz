package com.example.moviebuzz.data.repository

import com.example.androidarchitecture.util.Result
import com.example.moviebuzz.data.model.MovieDto
import com.example.moviebuzz.data.remote.MovieApiService
import com.example.moviebuzz.domain.movie.Movie

class MovieRemoteDataSource(
private val movieApiService: MovieApiService
): MovieDataSource.Remote {
    override suspend fun getMovies(): Result<MovieDto> {
        return try {
            val response = movieApiService.getMovies("ad200a977037b49ee6478593a415c0ce")
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun saveMovies(movies: Movie): String {
        TODO("Not yet implemented")
    }
}