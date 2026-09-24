package com.example.moviebuzz.data.model.current_playing

import androidx.room.Entity

@Entity(tableName = "current_movies")
data class CurrentMovieDbData(
    val id: Int,
    val title: String,
    val originalTitle: String,
    val overview: String?,
    val posterPath: String?,
    val backdropPath: String?,
    val releaseDate: String?,
)