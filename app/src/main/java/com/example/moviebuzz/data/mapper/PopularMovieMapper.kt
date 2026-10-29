package com.example.moviebuzz.data.mapper

import com.example.moviebuzz.data.model.popular_movie.PopularMovie
import com.example.moviebuzz.data.model.popular_movie.PopularMovieDbData
import com.example.moviebuzz.data.model.popular_movie.PopularMovieLocalData
import com.example.moviebuzz.data.model.popular_movie.Result

//fun PopularMovieDbData.toDomain(): PopularMovieDbData {
//    return PopularMovieDbData(
//        id = id,
//        originalTitle = originalTitle,
//        popularity = popularity,
//        overview = overview,
//        posterPath = posterPath,
//        backdropPath = backdropPath,
//        releaseDate = releaseDate,
//        voteAverage = voteAverage,
//        voteCount = voteCount
//    )
//}

fun Result.toDbData(): PopularMovieDbData{
    return PopularMovieDbData(
        id = id,
        originalTitle = original_title,
        popularity = popularity,
        overview = overview,
        posterPath = poster_path,
        backdropPath = backdrop_path,
        releaseDate = release_date,
        voteAverage = vote_average.toString(),
        voteCount = vote_count.toString()
    )
}
fun List<Result>.toDbData(): List<PopularMovieDbData> {
    return map { result ->
        result.toDbData()
    }
}

fun PopularMovieDbData.toDomain(): PopularMovieLocalData {
    return PopularMovieLocalData(
            id = id,
            originalTitle = originalTitle,
            popularity = popularity,
            overview = overview,
            posterPath = posterPath,
            backdropPath = backdropPath,
            releaseDate = releaseDate,
            voteAverage = voteAverage,
            voteCount = voteCount
        )
}