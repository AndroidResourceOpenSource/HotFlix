import Versions.hilt_version
import Versions.moshi_version
import Versions.nav_version
import Versions.retrofitVersion

object Versions {
    const val ktx = "1.10.1"
    const val composeBomVersion = "2023.03.00"
    const val compose_ui_Version = "1.7.2"
    const val lifecycle_version = "2.6.1"
    const val hilt_version = "2.46.1"
    const val retrofitVersion = "2.9.0"
    const val moshi_version = "1.14.0"
    const val nav_version = "2.5.3"
}

object Plugins {
    private const val agpVersion = "7.0.0"
    const val androidGradlePlugin = "com.android.tools.build:gradle:$agpVersion"
    const val junit = "junit:junit:4.13"
}

object Config {
    const val applicationId = "com.androidresource.hotflix"
    const val minSdk = 24
    const val targetSdk = 33
    const val compileSdk = 33
    const val versionCode = 1
    const val versionName = "1.0"

}

object Deps {

    object Androidx {

        val androidx = listOf(
            "androidx.core:core-ktx:${Versions.ktx}",
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_version}",
            "androidx.activity:activity-compose:${Versions.compose_ui_Version}"
        )

    }

    object compose {
        val composeBom = "androidx.compose:compose-bom:${Versions.composeBomVersion}"

        val composeBomDeps = listOf(
            "androidx.compose.ui:ui",
            "androidx.compose.ui:ui-graphics",
            "androidx.compose.ui:ui-tooling-preview",
            "androidx.compose.material3:material3"
        )

    }

    object testLibs {

        val composeAndroidTests = listOf(
            "androidx.compose.ui:ui-test-junit4"
        )
        val composeDebugTests = listOf(
            "androidx.compose.ui:ui-tooling",
            "androidx.compose.ui:ui-test-manifest"
        )
    }

    object Hilt {
        const val hiltAndroidGradlePlugin =
            "com.google.dagger:hilt-android-gradle-plugin:$hilt_version"
        const val android = "com.google.dagger:hilt-android:$hilt_version"
        const val lifecycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
        const val androidCompiler = "com.google.dagger:hilt-android-compiler:$hilt_version"
        const val compiler = "androidx.hilt:hilt-compiler:1.0.0"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
        const val converterMoshi = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
        const val moshi = "com.squareup.moshi:moshi-kotlin:$moshi_version"

    }

    object Okhttp {
        const val okhttpBom = "com.squareup.okhttp3:okhttp-bom:4.11.0"
        const val okhttp = "com.squareup.okhttp3:okhttp"
        const val okhttp_logging = "com.squareup.okhttp3:logging-interceptor"
    }

    object NavigationComponent {
        const val navComponent = "androidx.navigation:navigation-compose:$nav_version"
    }


}
