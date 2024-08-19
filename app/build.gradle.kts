plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("kotlin-kapt")
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.androidlearning"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.androidlearning"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.view.model)
    implementation(libs.saved.state.view.model)
    implementation(libs.live.data)
    implementation(libs.room.dependency)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.firebase.database)
    kapt(libs.room.kapt.version)
    implementation(libs.coroutine.dependency)
    implementation(libs.coroutine.android)
    implementation(libs.coroutine.support.room.dependency)
    implementation(libs.retrofit.dependency)
    implementation(libs.converter.gson)
    implementation(libs.okhttp.interceptor)
    implementation(libs.picasso.dependency)
    implementation(libs.fragment.dependency)
    implementation(libs.hilt.dependency)
//    kapt(libs.hilt.android.compilern)
    implementation(libs.glide.dependency)
    annotationProcessor(libs.room.annotation.process)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.gsonDependency)
}