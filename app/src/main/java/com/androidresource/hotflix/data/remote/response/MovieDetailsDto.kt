package com.androidresource.hotflix.data.remote.response


import androidx.annotation.Keep
import com.androidresource.hotflix.domain.entities.Movie
import com.androidresource.hotflix.utils.constants.EndPoints
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@Keep
@JsonClass(generateAdapter = true)
data class MovieDetailsDto(
    val id: Long,
    val adult: Boolean,
    @Json(name = "backdrop_path")
    val backDropPath: String,
    @Json(name ="poster_path")
    val posterPath: String,
    @Json(name ="genres")
    val genres: List<Genres>,
    @Json(name ="original_language")
    val originalLanguage: String,
    val title: String,
    val overview: String,
    val popularity: Double,
    @Json(name ="release_date")
    val releaseDate: String,
    val video: Boolean,
    @Json(name ="vote_average")
    val avgVote: Double,
    @Json(name ="vote_count")
    val voteCount: Int
) {

    fun asDomainModel() = Movie(
        id = id,
        isAdult = adult,
        backDropUrl = EndPoints.IMAGE_BASE_URL_W500 + backDropPath,
        posterUrl = EndPoints.IMAGE_BASE_URL_W500 + posterPath,
        genreIds = genres.map { it.id },
        genres = genres.map { it.name },
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

data class Genres(
    val id: Int,
    val name: String
)