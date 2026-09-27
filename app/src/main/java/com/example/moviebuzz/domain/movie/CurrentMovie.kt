package com.example.moviebuzz.domain.movie

data class CurrentMovie(
    val id: Int,
    val originalTitle: String,
    val popularity: Double,
    val overview: String?,
    val posterPath: String?,
    val backdropPath: String?,
    val releaseDate: String?
)
