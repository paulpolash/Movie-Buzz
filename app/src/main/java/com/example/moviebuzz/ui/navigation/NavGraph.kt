package com.example.moviebuzz.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Routes.Home.route){
        composable(Routes.Home.route){

        }

        composable(Routes.SplashScreen.route){

        }
    }
}