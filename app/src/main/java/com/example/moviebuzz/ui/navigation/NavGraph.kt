package com.example.moviebuzz.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.moviebuzz.ui.screen.HomeScreen
import com.example.moviebuzz.ui.screen.SplashScreen
import com.example.moviebuzz.ui.viewModel.MovieViewModel

@Composable
fun NavGraph(
    navController: NavHostController, viewModel: MovieViewModel
) {
    NavHost(navController = navController, startDestination = Routes.SplashScreen.route){
        composable(Routes.Home.route){
//            val viewModel: MovieViewModel = hiltViewModel()

            val state = viewModel.uiState.collectAsState()
//            HomeScreen(viewModel,true, "no issue")
            HomeScreen(
                movies = state.value.currentMovies,

                onSearchClick = {
                    // navController.navigate(Routes.Search.route)
                },

                onMovieClick = { movie ->
                    // navController.navigate(
                    //     Routes.MovieDetail.createRoute(movie.id)
                    // )
                },

                onFavoritesClick = {
                    // navController.navigate(Routes.Favorites.route)
                }
            )
        }

        composable(Routes.SplashScreen.route){
            SplashScreen(
                onNavigateToHome = {
                    navController.navigate(Routes.Home.route){
                        popUpTo(Routes.SplashScreen.route) {
                            inclusive = false
                        }
                    }
                }
            )
        }

//        composable(Routes.Home.route) {
//
//        }
    }
}