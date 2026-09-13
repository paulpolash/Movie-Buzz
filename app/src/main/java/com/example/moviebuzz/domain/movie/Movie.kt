package com.example.moviebuzz.domain.movie

data class Movie(
    val id: Int,
    val title: String,
    val originalTitle: String,
    val overview: String?,
    val posterPath: String?,
    val backdropPath: String?,
    val releaseDate: String?,
    val runtime: Int,
    val voteAverage: Double,
    val voteCount: Int,
    val tagline: String?,
    val homepage: String?
)
