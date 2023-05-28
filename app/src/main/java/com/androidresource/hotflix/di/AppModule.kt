package com.androidresource.hotflix.di

import com.androidresource.hotflix.data.remote.MovieService
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.androidresource.hotflix.R
import com.androidresource.hotflix.data.local.perfs.UserPreferences
import com.androidresource.hotflix.data.remote.Networking
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {



    @Singleton
    @Provides
    fun providesMoshi() = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideSharedPreferences(app: Application): SharedPreferences =
        app.getSharedPreferences(
            app.resources.getString(R.string.app_name),
            Context.MODE_PRIVATE
        )

    @Provides
    @Singleton
    fun provideSharedPreferencesEditor(sharedPreferences: SharedPreferences): SharedPreferences.Editor =
        sharedPreferences.edit()


    @Provides
    @Singleton
    fun provideUserPrefs(
        sharedPreferences: SharedPreferences,
        editor: SharedPreferences.Editor,
    ): UserPreferences = UserPreferences(sharedPreferences,editor)

    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    fun provideNetworkService(app: Application, preferences: SharedPreferences): MovieService =
        Networking.create(
            "http://api.themoviedb.org/3/",
            app.cacheDir,
            10 * 1024 * 1024,
            preferences// 10MB
        )

}