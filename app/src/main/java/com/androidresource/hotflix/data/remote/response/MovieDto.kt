package com.androidresource.hotflix.data.remote.response

import androidx.annotation.Keep
import com.androidresource.hotflix.domain.entities.Movie
import com.androidresource.hotflix.utils.constants.EndPoints
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@Keep
@JsonClass(generateAdapter = true)
data class MoviesDto(
    val page: Int,
    val results: List<MovieDto>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)

@Keep
@JsonClass(generateAdapter = true)
data class MovieDto(
    val id: Long,
    val adult: Boolean,
    @Json(name = "backdrop_path")
    val backDropPath: String,
    @Json(name = "poster_path")
    val posterPath: String,
    @Json(name = "genre_ids")
    val genreIds: List<Int>,
    @Json(name = "original_language")
    val originalLanguage: String,
    val title: String,
    val overview: String,
    val popularity: Double,
    @Json(name = "release_date")
    val releaseDate: String,
    val video: Boolean,
    @Json(name = "vote_average")
    val avgVote: Double,
    @Json(name = "vote_count")
    val voteCount: Int
) {

    fun asDomainModel() = Movie(
        id = id,
        isAdult = adult,
        backDropUrl = EndPoints.IMAGE_BASE_URL_W500 + backDropPath,
        posterUrl = EndPoints.IMAGE_BASE_URL_W500 + posterPath,
        genreIds = genreIds,
        language = originalLanguage,
        title = title,
        overview = overview,
        popularity = popularity,
        releaseDate = releaseDate,
        isVideoAvailable = video,
        avgVote = avgVote,
        voteCount = voteCount
    )
}

data class SimilarMoviesDto(
    val results: List<SimilarMovieDto>
)

data class SimilarMovieDto(
    val id: Int,
    val adult: Boolean,
    @Json(name = "backdrop_path")
    val backDropPath: String,
    @Json(name = "poster_path")
    val posterPath: String,
    @Json(name = "original_language")
    val originalLanguage: String,
    val title: String,
    val overview: String,
    val video: Boolean,
) {
    fun asDomainModel() = Movie(
        id = id.toLong(),
        isAdult = adult,
        backDropUrl = EndPoints.IMAGE_BASE_URL_W500 + backDropPath,
        posterUrl = EndPoints.IMAGE_BASE_URL_W500 + posterPath,
        genreIds = listOf(),
        language = originalLanguage,
        title = title,
        overview = overview,
        popularity = 0.0,
        releaseDate = "",
        isVideoAvailable = video,
        avgVote = 0.0,
        voteCount = 0
    )
}