package com.example.moviebuzz.ui.screen

import com.example.moviebuzz.data.model.popular_movie.PopularMovie
import com.example.moviebuzz.domain.movie.CurrentMovie
import com.example.moviebuzz.domain.movie.Movie

data class MovieUiState(
    val isLoading: Boolean = false,
    val movies: Movie? = null,
    val error: String? = null,
    val currentMovies: List<CurrentMovie> = emptyList(),
    val popularMovies: PopularMovie = PopularMovie(0, emptyList(), 0, 0),


    val searchQuery: String = "",
    val searchResults: List<CurrentMovie> = emptyList(),
    val isSearchLoading: Boolean = false,
    val searchError: String? = null
)
