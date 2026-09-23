package com.example.moviebuzz.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviebuzz.domain.movie.Movie
@Preview(showBackground = true)
@Composable
fun HomeScreen(
//    movies: List<Movie>,
    isLoading: Boolean,
    error: String?,
//    onMovieClick: (Movie) -> Unit
){
    when {
        isLoading -> {
            CircularProgressIndicator()
        }

        error != null -> {
            Text(text = error)
        }

//        movies.isEmpty() -> {
//            Text(text = "No movies found")
//        }

        else -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
//                items(movies) { movie ->
//                    MovieItem(
//                        movie = movie,
//                        onClick = {
//                            onMovieClick(movie)
//                        }
//                    )
//                }
            }
        }
    }
}
