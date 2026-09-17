package com.example.moviebuzz.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidarchitecture.util.Result
import com.example.moviebuzz.domain.movie.Movie
import com.example.moviebuzz.domain.useCase.UseCase
import com.example.moviebuzz.ui.screen.MovieUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel(private val movieUseCase: UseCase): ViewModel() {
        private val _uiState = MutableStateFlow(MovieUiState())
        val uiState : StateFlow<MovieUiState> = _uiState
    private val _movieData = MutableStateFlow<List<Movie>>(emptyList())
    val movieData: StateFlow<List<Movie>> = _movieData

    fun getMovie(){
        viewModelScope.launch(Dispatchers.IO){

            _uiState.value = MovieUiState(
                isLoading = true
            )

            when(val result = movieUseCase()){
                is Result.Success<*> ->{
                    withContext(Dispatchers.IO){
                        _movieData.value = result.data as List<Movie>
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
}