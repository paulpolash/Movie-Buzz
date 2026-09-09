package com.example.moviebuzz.data.remote

import com.example.moviebuzz.data.model.MovieDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET(ApiEndPoints.GET_MOVIE)
    suspend fun getMovies(@Query("api_key") apiKey: String): MovieDto
}