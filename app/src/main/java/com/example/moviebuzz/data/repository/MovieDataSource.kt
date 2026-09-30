package com.example.moviebuzz.data.repository

import com.example.androidarchitecture.util.Result
import com.example.moviebuzz.data.model.MovieDbData
import com.example.moviebuzz.data.model.MovieDto
import com.example.moviebuzz.data.model.current_playing.CurrentMovieDbData
import com.example.moviebuzz.data.model.current_playing.CurrentMovieDto
import com.example.moviebuzz.data.model.current_playing.CurrentMovies
import com.example.moviebuzz.domain.movie.CurrentMovie
import com.example.moviebuzz.domain.movie.Movie

interface MovieDataSource {

    interface Remote{
        suspend fun getMovies(): Result<MovieDto>
        suspend fun saveMovies(movies: Movie): String
        suspend fun getCurrentMovies(): Result<CurrentMovies>
    }

    interface local{
        suspend fun getMovies(): Result<Movie>
        suspend fun saveMovies(movies: MovieDbData)
        suspend fun getCurrentMovies(): Result<List<CurrentMovie>>
        suspend fun saveCurrentMovies(movies: List<CurrentMovieDbData>)
    }
}