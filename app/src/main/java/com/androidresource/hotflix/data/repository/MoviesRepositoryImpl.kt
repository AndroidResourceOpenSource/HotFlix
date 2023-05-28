package com.androidresource.hotflix.data.repository

import com.androidresource.hotflix.data.remote.MovieService
import javax.inject.Inject


class MoviesRepositoryImpl @Inject constructor(
    private val service: MovieService
) : MoviesRepository {

    companion object {
        private const val TAG = "MoviesRepo"
    }

}