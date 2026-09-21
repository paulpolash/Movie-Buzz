package com.example.moviebuzz.ui.screen

import com.example.moviebuzz.domain.movie.Movie

data class MovieUiState(
    val isLoading: Boolean = false,
    val movies: Movie?= null,
    val error: String? = null
)
