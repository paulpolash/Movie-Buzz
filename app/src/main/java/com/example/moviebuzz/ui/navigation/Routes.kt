package com.example.moviebuzz.ui.navigation

sealed class Routes(var route: String) {
    data object SplashScreen : Routes("splash")
    data object Home : Routes("home")
    data object Search : Routes("search")
    data object Favorite : Routes("favorite")

}