package com.example.moviebuzz.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.moviebuzz.MainActivity
import com.example.moviebuzz.ui.screen.HomeScreen
import com.example.moviebuzz.ui.screen.SplashScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Routes.SplashScreen.route){
        composable(Routes.Home.route){
            HomeScreen(true, "no issue")
        }

        composable(Routes.SplashScreen.route){
            SplashScreen(
                onNavigateToHome = {
                    navController.navigate(Routes.Home.route){
                        popUpTo(Routes.SplashScreen.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Routes.Home.route) {

        }
    }
}