package com.example.moviebuzz.domain.useCase

import com.example.androidarchitecture.util.Result
import com.example.moviebuzz.domain.movie.Movie
import com.example.moviebuzz.domain.repository.MovieRepository

class UseCase(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(): Result<Movie> {
        return movieRepository.getMovies()
    }
}