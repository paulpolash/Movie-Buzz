package com.example.moviebuzz.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieDbData(
    @PrimaryKey
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
