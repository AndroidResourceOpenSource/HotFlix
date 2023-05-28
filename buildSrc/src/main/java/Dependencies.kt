object Versions {
    const val ktx = "1.10.1"
    const val composeBomVersion = "2023.03.00"
    const val compose_ui_Version = "1.7.2"
    const val lifecycle_version = "2.6.1"
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


}
