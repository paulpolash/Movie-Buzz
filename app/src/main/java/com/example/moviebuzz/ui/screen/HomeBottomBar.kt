package com.example.moviebuzz.ui.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
private val SecondaryText = Color(0xFF9EADBD)
private val PrimaryPink = Color(0xFFFF315B)
@Composable
fun HomeBottomBar(
    onHomeClick: () -> Unit,
    onMoviesClick: () -> Unit,
    onSearchClick: () -> Unit,
    onFavoritesClick: () -> Unit
) {
    NavigationBar(
        containerColor = Color(0xFF0B1B2A),
        contentColor = SecondaryText
    ) {
        NavigationBarItem(
            selected = true,
            onClick = onHomeClick,
            icon = {
                Icon(Icons.Default.Home, contentDescription = "Home")
            },
            label = { Text("Home") },
            colors = navigationItemColors()
        )

        NavigationBarItem(
            selected = false,
            onClick = onMoviesClick,
            icon = {
                Icon(Icons.Default.Movie, contentDescription = "Movies")
            },
            label = { Text("Movies") },
            colors = navigationItemColors()
        )

        NavigationBarItem(
            selected = false,
            onClick = onSearchClick,
            icon = {
                Icon(Icons.Default.Search, contentDescription = "Search")
            },
            label = { Text("Search") },
            colors = navigationItemColors()
        )

        NavigationBarItem(
            selected = false,
            onClick = onFavoritesClick,
            icon = {
                Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorites")
            },
            label = { Text("Favorites") },
            colors = navigationItemColors()
        )
    }
}

@Composable
private fun navigationItemColors() = NavigationBarItemDefaults.colors(
    selectedIconColor = PrimaryPink,
    selectedTextColor = PrimaryPink,
    indicatorColor = Color.Transparent,
    unselectedIconColor = SecondaryText,
    unselectedTextColor = SecondaryText
)