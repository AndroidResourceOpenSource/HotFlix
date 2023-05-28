package com.androidresource.hotflix.data.remote

import com.androidresource.hotflix.data.remote.response.MovieDetailsDto
import com.androidresource.hotflix.utils.constants.EndPoints
import com.androidresource.hotflix.data.remote.response.MoviesDto
import com.androidresource.hotflix.data.remote.response.MoviesVideosDto
import com.androidresource.hotflix.data.remote.response.SimilarMoviesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query




interface MovieService {
    @GET(EndPoints.ENDPOINT_TOP_RATED)
    suspend fun getTopRatedMovies(
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String,
    ): MoviesDto

    @GET(EndPoints.ENDPOINT_NOW_PLAYING)
    suspend fun getNowPlayingMovies(
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String,
    ): MoviesDto

    @GET(EndPoints.ENDPOINT_POPULAR)
    suspend fun getPopularMovies(
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String,
    ): MoviesDto

    @GET(EndPoints.ENDPOINT_MOVIE)
    suspend fun getMovieById(
        @Path("movie_id") movieId: Long,
        @Query("api_key") apiKey: String
    ): MovieDetailsDto

    @GET(EndPoints.ENDPOINT_MOVIE_VIDEO)
    suspend fun getMovieVideosById(
        @Path("movie_id") movieId: Long,
        @Query("api_key") apiKey: String
    ): MoviesVideosDto

    @GET(EndPoints.ENDPOINT_SIMILAR_MOVIES)
    suspend fun getSimilarMovies(
        @Path("movie_id") movieId: Long,
        @Query("api_key") apiKey: String
    ): SimilarMoviesDto

}