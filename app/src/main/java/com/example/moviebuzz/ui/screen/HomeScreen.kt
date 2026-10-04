package com.example.moviebuzz.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviebuzz.domain.movie.Movie
import com.example.moviebuzz.ui.viewModel.MovieViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.example.moviebuzz.domain.movie.CurrentMovie
private val Background = Color(0xFF071522)
private val SecondaryText = Color(0xFF9EADBD)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    movies: List<CurrentMovie>,
    onSearchClick: () -> Unit = {},
    onMenuClick: () -> Unit = {},
    onMovieClick: (CurrentMovie) -> Unit = {},
    onHomeClick: () -> Unit = {},
    onMoviesClick: () -> Unit = {},
    onFavoritesClick: () -> Unit = {}
)
{
    Scaffold(
        containerColor = Background,
        topBar = {
            HomeTopBar(
                onSearchClick = onSearchClick,
                onMenuClick = onMenuClick
            )
        },
        bottomBar = {
            HomeBottomBar(
                onHomeClick = onHomeClick,
                onMoviesClick = onMoviesClick,
                onSearchClick = onSearchClick,
                onFavoritesClick = onFavoritesClick
            )
        }
    ){ innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (movies.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No movies available",
                        color = SecondaryText
                    )
                }
            } else {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    item {
                        FeaturedMovieCard(
                            movie = movies.first(),
                            onClick = { onMovieClick(movies.first()) }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                MovieSection(
                    title = "Now Playing",
                    movies = movies,
                    onMovieClick = onMovieClick,
                    onSearchClick = onSearchClick
                )

                Spacer(modifier = Modifier.height(24.dp))

                MovieSection(
                    title = "Popular Movies",
                    movies = movies,
                    onMovieClick = onMovieClick,
                    onSearchClick = onSearchClick
                )
            }
        }
    }
}