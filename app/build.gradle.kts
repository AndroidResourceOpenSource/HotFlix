plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = Config.applicationId
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId =Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

//
//        buildConfigField("String", "BASE_URL", "http://api.themoviedb.org/3/")
//        buildConfigField("String", "API_KEY", "${network_url}")


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}


dependencies {

    Deps.Androidx.androidx.forEach(::implementation)
    implementation(platform(Deps.compose.composeBom))
    Deps.compose.composeBomDeps.forEach(::implementation)

    //navigation component
    implementation(Deps.NavigationComponent.navComponent)

    // Dagger hilt
    implementation(Deps.Hilt.android)
    kapt(Deps.Hilt.androidCompiler)


    //region Network Libs
    implementation(Deps.Retrofit.retrofit)

    implementation(Deps.Retrofit.converterMoshi)
    implementation(Deps.Retrofit.moshi)

    implementation(platform(Deps.Okhttp.okhttpBom))
    implementation(Deps.Okhttp.okhttp)
    implementation(Deps.Okhttp.okhttp_logging)


    //endregion




    //*********test Library ************
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform(Deps.compose.composeBom))
    Deps.testLibs.composeAndroidTests.forEach(::androidTestImplementation)
    Deps.testLibs.composeDebugTests.forEach(::debugImplementation)

}