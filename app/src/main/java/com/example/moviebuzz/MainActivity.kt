package com.example.moviebuzz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviebuzz.data.local.movies.MovieDatabase
import com.example.moviebuzz.data.remote.RetrofitInstance
import com.example.moviebuzz.data.repository.MovieLocalDataSource
import com.example.moviebuzz.data.repository.MovieRemoteDataSource
import com.example.moviebuzz.data.repository.MovieRepositoryIml
import com.example.moviebuzz.domain.useCase.UseCase
import com.example.moviebuzz.ui.theme.MovieBuzzTheme
import com.example.moviebuzz.ui.viewModel.MovieViewModel

class MainActivity : ComponentActivity() {
private lateinit var movieViewModel: MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database = MovieDatabase.getDatabase(applicationContext)
        val movieDao = database.movieDao()
        val localDataSource = MovieLocalDataSource(movieDao)
        val apiService = RetrofitInstance.api
        val remoteDataSource = MovieRemoteDataSource(apiService)
        val movieRepository = MovieRepositoryIml(localDataSource, remoteDataSource)
        val movieData = UseCase(movieRepository)
        val movieViewModel = MovieViewModel(movieData)

        enableEdgeToEdge()
        setContent {
            movieViewModel.getMovie()
            val data = movieViewModel.movieData
            MovieBuzzTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovieBuzzTheme {
        Greeting("Polash")
    }
}