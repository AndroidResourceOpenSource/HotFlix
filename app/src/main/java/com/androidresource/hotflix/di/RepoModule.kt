package com.androidresource.hotflix.di

import com.androidresource.hotflix.data.repository.MoviesRepository
import com.androidresource.hotflix.data.repository.MoviesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun bindMovieRepository(impl: MoviesRepositoryImpl): MoviesRepository
}