package com.example.moviebuzz.data.mapper

import com.example.moviebuzz.data.model.current_playing.CurrentMovieDbData
import com.example.moviebuzz.data.model.current_playing.Result
import com.example.moviebuzz.data.model.current_playing.toMovieDbData
import com.example.moviebuzz.domain.movie.CurrentMovie


fun Result.toDbData(): CurrentMovieDbData {
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
fun CurrentMovieDbData.toDomain(): CurrentMovie{
    return CurrentMovie(
        id = id,
        originalTitle = originalTitle,
        popularity = popularity,
        overview = overview,
        posterPath = posterPath,
        backdropPath = backdropPath,
        releaseDate = releaseDate
    )
}

fun List<Result>.toDbData(): List<CurrentMovieDbData> {
    return map { result ->
        result.toMovieDbData()
    }
}