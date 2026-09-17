package com.example.moviebuzz.data.mapper

import com.example.moviebuzz.data.model.MovieDbData
import com.example.moviebuzz.data.model.MovieDto
import com.example.moviebuzz.domain.movie.Movie

fun MovieDto.toMovieDbData(): MovieDbData {
    return MovieDbData(
        id = id,
        title = title,
        originalTitle = original_title,
        overview = overview,
        posterPath = poster_path,
        backdropPath = backdrop_path,
        releaseDate = release_date,
        runtime = runtime,
        voteAverage = vote_average,
        voteCount = vote_count,
        tagline = tagline,
        homepage = homepage
    )
}

fun MovieDbData.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        originalTitle = originalTitle,
        overview = overview,
        posterPath = posterPath,
        backdropPath = backdropPath,
        releaseDate = releaseDate,
        runtime = runtime,
        voteAverage = voteAverage,
        voteCount = voteCount,
        tagline = tagline,
        homepage = homepage
    )
}