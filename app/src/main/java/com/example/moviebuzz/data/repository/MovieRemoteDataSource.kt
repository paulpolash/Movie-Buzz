package com.example.moviebuzz.data.repository

import com.example.androidarchitecture.util.Result
import com.example.moviebuzz.data.model.MovieDto
import com.example.moviebuzz.data.model.current_playing.CurrentMovieDto
import com.example.moviebuzz.data.model.current_playing.CurrentMovies
import com.example.moviebuzz.data.remote.MovieApiService
import com.example.moviebuzz.domain.movie.CurrentMovie
import com.example.moviebuzz.domain.movie.Movie

class MovieRemoteDataSource(
private val movieApiService: MovieApiService
): MovieDataSource.Remote {
    override suspend fun getMovies(): Result<MovieDto> {
        return try {
            val response = movieApiService.getMovies("ad200a977037b49ee6478593a415c0ce")
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun saveMovies(movies: Movie): String {
        TODO("Not yet implemented")
    }

    override suspend fun getCurrentMovies(): Result<CurrentMovies> {
        return try {
            val auth = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZDIwMGE5NzcwMzdiNDllZTY0Nzg1OTNhNDE1YzBjZSIsIm5iZiI6MTY2MjU0OTE5MS4yNzEwMDAxLCJzdWIiOiI2MzE4N2NjN2VkMmFjMjAwN2EzNDRiMjMiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.tWF_CJvDcSoEpAOsiYDf2nLyhj1Kh-SjtXKrPnX01tQ"
            val response = movieApiService.getCurrentMovies(auth,"en", 1)
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}