package com.androidresource.hotflix.utils.extenstions

import android.content.SharedPreferences
import com.squareup.moshi.Moshi


inline fun <reified T : Any> SharedPreferences.getObject(key: String): T? {
    val moshi =  Moshi.Builder().build()
    val json = getString(key, null)
    if (json != null) {
        val adapter = moshi.adapter(T::class.java)
        return adapter.fromJson(json)
    }
    return null
}

@Suppress("UNCHECKED_CAST")
inline fun <reified T : Any> SharedPreferences.get(key: String, defaultValue: T? = null): T {
    val moshi = Moshi.Builder().build()
    return when (T::class) {
        Boolean::class -> getBoolean(key, defaultValue as? Boolean? ?: false) as T
        Float::class -> getFloat(key, defaultValue as? Float? ?: 0.0f) as T
        Int::class -> getInt(key, defaultValue as? Int? ?: 0) as T
        Long::class -> getLong(key, defaultValue as? Long? ?: 0L) as T
        String::class -> getString(key, defaultValue as? String? ?: "") as T
        else -> {
            if (defaultValue is Set<*>) {
                getStringSet(key, defaultValue as Set<String>) as T
            } else {
                val typeName = T::class.java.simpleName
                throw Error("Unable to get shared preference with value type '$typeName'. Use getObject")
            }
        }
    }
}

@Suppress("UNCHECKED_CAST")
inline operator fun <reified T : Any> SharedPreferences.set(key: String, value: T) {
    val moshi = Moshi.Builder().build()
    val adapter = moshi.adapter(T::class.java)
    val json = adapter.toJson(value)
    with(edit()) {
        putString(key, json)
        commit()
    }
}
