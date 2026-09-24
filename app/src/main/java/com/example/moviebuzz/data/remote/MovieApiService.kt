package com.example.moviebuzz.data.remote

import com.example.moviebuzz.data.model.MovieDto
import com.example.moviebuzz.data.model.current_playing.CurrentMovies
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET(ApiEndPoints.GET_MOVIE)
    suspend fun getMovies(@Query("api_key") apiKey: String): MovieDto

    @GET(ApiEndPoints.GET_CURRENT_PLAYING)
    suspend fun getCurrentMovies(@Query("language") language: String, @Query("page") page: Int): CurrentMovies

}