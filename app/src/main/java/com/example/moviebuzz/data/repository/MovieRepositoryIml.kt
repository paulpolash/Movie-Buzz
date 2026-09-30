package com.example.moviebuzz.data.repository

import android.util.Log
import com.example.androidarchitecture.util.Result
import com.example.moviebuzz.data.mapper.toCurrentMovieDbData
import com.example.moviebuzz.data.mapper.toDbData
import com.example.moviebuzz.data.mapper.toMovieDbData
import com.example.moviebuzz.domain.movie.CurrentMovie
import com.example.moviebuzz.domain.movie.Movie
import com.example.moviebuzz.domain.repository.MovieRepository

class MovieRepositoryIml(
    private val localDataSource: MovieLocalDataSource,
    private val remoteDataSource: MovieRemoteDataSource
): MovieRepository {
    override suspend fun getMovies(): Result<Movie> {
        //check local first
        return when (val localResult = localDataSource.getMovies()) {
            is Result.Success ->{
                localResult
            }
            is Result.Error -> {
                //local is empty call remote and save to local
                when (val remoteResult = remoteDataSource.getMovies()) {
                    is Result.Success -> {
                        //save to local
                        localDataSource.saveMovies(remoteResult.data.toMovieDbData())
                        //read again from local
                        localDataSource.getMovies()
                    }
                    is Result.Error -> {
                        remoteResult
                    }
                }
            }
            else -> {
                Log.d("TAG", "Unknown error")
            }
        }as Result<Movie>
    }

    override suspend fun getCurrentMovies(): Result<List<CurrentMovie>> {
        return when (val currentLocalResult = localDataSource.getCurrentMovies()){

            is Result.Success ->{
                currentLocalResult
            }

            is Result.Error -> {
                when(val remoteResult = remoteDataSource.getCurrentMovies()){
                    is Result.Success -> {
                        localDataSource.saveCurrentMovies(remoteResult.data.results.toCurrentMovieDbData())
                        localDataSource.getCurrentMovies()
                    }
                    is Result.Error -> {
                        Result.Error(remoteResult.error)
                    }
//                    else -> {
//                        Log.d("TAG", "Unknown error")
//                    }

                }
            }
        } //as Result<List<CurrentMovie>>

    }
}