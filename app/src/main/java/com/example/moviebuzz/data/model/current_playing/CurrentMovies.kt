package com.example.moviebuzz.data.model.current_playing

data class CurrentMovies(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)
//fun Result.toCurrentMovieDbData(): CurrentMovieDbData {
//    return CurrentMovieDbData(
//        id = id,
//        originalTitle = original_title,
//        popularity = popularity,
//        overview = overview,
//        posterPath = poster_path,
//        backdropPath = backdrop_path,
//        releaseDate = release_date
//    )
//}