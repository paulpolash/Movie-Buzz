package com.example.moviebuzz.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HomeScreen(
    viewModel: MovieViewModel,
    isLoading: Boolean,
    error: String?,
){
    val state by viewModel.uiState.collectAsState()
    val movies = state.currentMovies
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Movie Buzz", color = androidx.compose.ui.graphics.Color.White)
                },
                actions = {
                    IconButton(onClick = {
                    /* Search action */
                        viewModel.getCurrentMovies()
                        val movies = viewModel.uiState
                    }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
    when {
        isLoading -> {
            CircularProgressIndicator()
        }

        error != null -> {
            Text(text = error)
        }

        movies.isEmpty() -> {
            Text(text = "No movies found")
        }

        else -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(movies) { movie ->
//                    MovieItem(
//                        movie = movie,
//                        onClick = { }
//                    )
                    Text(
                        text = movie.originalTitle,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}
    }
