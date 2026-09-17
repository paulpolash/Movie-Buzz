package com.example.moviebuzz.ui.screen

import com.example.moviebuzz.domain.movie.Movie

data class MovieUiState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String? = null
)
