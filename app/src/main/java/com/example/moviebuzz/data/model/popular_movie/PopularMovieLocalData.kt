package com.example.moviebuzz.data.model.popular_movie

data class PopularMovieLocalData(
    val id: Int,
    val originalTitle: String,
    val popularity: Double,
    val overview: String?,
    val posterPath: String?,
    val backdropPath: String?,
    val releaseDate: String?,
    val voteAverage: String?,
    val voteCount: String?
)
