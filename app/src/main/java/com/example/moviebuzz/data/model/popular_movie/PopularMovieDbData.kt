package com.example.moviebuzz.data.model.popular_movie

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popular_movie")
class PopularMovieDbData (
    @PrimaryKey
    val id: Int,
    val originalTitle: String,
    val popularity: Double,
    val overview: String?,
    val posterPath: String?,
    val backdropPath: String?,
    val releaseDate: String?,
    val vote_average: String?,
    val vote_count: String?,
)