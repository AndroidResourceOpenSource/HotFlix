package com.androidresource.hotflix.data.local.perfs

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPreferences @Inject constructor(
    private val pref: SharedPreferences,
    private val editor: SharedPreferences.Editor
) {

    /**
     * all the KEY's related to Shared Prefrences
     */
    companion object {
        private const val LOGGED_IN = "loggedIn"
        private const val JWT_TOKEN = "Jwt"
    }


    fun loggedOut() {
        pref.edit().clear().apply()
        editor.clear();
        editor.commit();
    }


}