package com.example.moviebuzz.ui.navigation

sealed class Routes(var route: String) {
    data object SplashScreen : Routes("splash")
    data object Home : Routes("home")
    data object Search : Routes("search")
    data object Favorite : Routes("favorite")
    data object MovieDetail : Routes("movie_detail/{movieId}"){
        fun createRoute(movieId: String) = "movie_detail/$movieId"
    }
    object PersonDetails : Routes("detail/{personId}"){
        fun createRoute(personId: Int) = "detail/$personId"
    }

}