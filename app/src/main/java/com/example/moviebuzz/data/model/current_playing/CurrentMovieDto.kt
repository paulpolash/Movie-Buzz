package com.example.moviebuzz.data.model.current_playing

import com.example.moviebuzz.data.model.Genre
import com.example.moviebuzz.data.model.MovieDbData

data class CurrentMovieDto(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: Any,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
)
    fun Result.toMovieDbData(): CurrentMovieDbData {
        return CurrentMovieDbData(
            id = id,
            originalTitle = original_title,
            popularity = popularity,
            overview = overview,
            posterPath = poster_path,
            backdropPath = backdrop_path,
            releaseDate = release_date
        )
    }

