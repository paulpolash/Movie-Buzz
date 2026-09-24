package com.example.moviebuzz.data.model.current_playing

import com.example.moviebuzz.data.model.Genre

data class CurrentMovieDto(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: Any,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
)
