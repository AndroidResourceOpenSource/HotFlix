package com.androidresource.hotflix.data.remote

import android.content.SharedPreferences
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit


object Networking {

    private const val HEADER_ACCESS_TOKEN = "Jwt"
    private const val NETWORK_CALL_TIMEOUT = 90

    /**
     * This method is a Generic Method
     * to Create an Instance of Service Class
     */
    fun create(
        baseUrl: String,
        cacheDir: File,
        cacheSize: Long,
        prefs: SharedPreferences
    ): MovieService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(
                OkHttpClient.Builder()
                   .cache(Cache(cacheDir, cacheSize))
                    .addInterceptor(HttpLoggingInterceptor()
                        .apply {
                            //level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                           // else HttpLoggingInterceptor.Level.NONE
                        })
                    .readTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .connectTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build()
            )
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MovieService::class.java)
    }
}