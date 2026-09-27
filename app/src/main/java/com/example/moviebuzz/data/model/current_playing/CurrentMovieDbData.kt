package com.example.moviebuzz.data.model.current_playing

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "current_movies")
data class CurrentMovieDbData(
    @PrimaryKey
    val id: Int,
    val originalTitle: String,
    val popularity: Double,
    val overview: String?,
    val posterPath: String?,
    val backdropPath: String?,
    val releaseDate: String?,
)