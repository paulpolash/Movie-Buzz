package com.example.moviebuzz.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidarchitecture.util.Result
import com.example.moviebuzz.domain.movie.CurrentMovie
import com.example.moviebuzz.domain.movie.Movie
import com.example.moviebuzz.domain.useCase.UseCase
import com.example.moviebuzz.ui.screen.MovieUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel(private val movieUseCase: UseCase): ViewModel() {
    private val _uiState = MutableStateFlow(MovieUiState())
    val uiState : StateFlow<MovieUiState> = _uiState
    private val _movieData = MutableStateFlow<Movie?>(null)
    val movieData: StateFlow<Movie?> = _movieData.asStateFlow()
    private val _CurrentMovieList = MutableStateFlow<List<CurrentMovie>>(emptyList())
    val currentMovieList: StateFlow<List<CurrentMovie>> = _CurrentMovieList.asStateFlow()

    fun getMovie(){
        viewModelScope.launch(Dispatchers.IO){

            _uiState.value = MovieUiState(
                isLoading = true
            )

            when(val result = movieUseCase()){
                is Result.Success<*> ->{
                    withContext(Dispatchers.IO){
                        _movieData.value = result.data as Movie?
                        _uiState.value = MovieUiState(
                            movies = result.data
                        )
                    }
                }
                is Result.Error ->{
                    _uiState.value = MovieUiState(
                        error = result.error.message
                    )
                }
            }

        }
    }

    fun getCurrentMovies(){
        viewModelScope.launch(Dispatchers.IO){
            _uiState.value = MovieUiState(
                isLoading = true
            )
            when (val result = movieUseCase.getCurrentMovies()){
                is Result.Success -> {
                    withContext(Dispatchers.IO) {
                        _CurrentMovieList.value = result.data
                        _uiState.value = MovieUiState(
                            currentMovies = result.data
                        )
                    }
                }
                is Result.Error -> {
                    _uiState.value = MovieUiState(
                        error = result.error.message
                    )
                }
            }
        }
    }
}