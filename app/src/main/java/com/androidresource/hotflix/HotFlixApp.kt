package com.androidresource.hotflix

import android.app.Application
import com.squareup.moshi.Moshi
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class HotFlixApp : Application() {

    @Inject
    lateinit var moshi:Moshi



    override fun onCreate() {
        super.onCreate()

    }
}