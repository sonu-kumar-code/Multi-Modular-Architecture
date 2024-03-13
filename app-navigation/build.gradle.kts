import com.app.composemultimodule.gradle.Android
import com.app.composemultimodule.gradle.Library

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Android.compileSdk
    buildToolsVersion = Android.buildTools
    namespace = "com.app.composemultimodule"

    defaultConfig {
        minSdk = Android.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        compose = true
        buildConfig = false
    }

    buildTypes {
        getByName("release"){
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    composeOptions{
        kotlinCompilerExtensionVersion = com.app.composemultimodule.gradle.Version.composeCompiler
    }
}

dependencies {

    implementation(project(":onboarding"))
    implementation(project(":common"))

    implementation(Library.kotlin.kotlinxSerialization)
    implementation(Library.kotlin.kotlinxCollections)
    implementation(Library.Androidx.splash)

    implementation(Library.Material.material)

    implementation(Library.Androidx.coreKtx)
    implementation(Library.Androidx.workRuntime)
    implementation(Library.Androidx.workRuntimeKtxExt)

    implementation(Library.Hilt.core)
    kapt(Library.Hilt.compiler)

    implementation(Library.Accompanist.navigation)
    implementation(Library.Accompanist.pager)
    implementation(Library.Accompanist.pagerIndicators)
    implementation(Library.Accompanist.systemUiController)

    val composeBom = platform(Library.Compose.composeBillOfMaterials)
    implementation(composeBom)
    implementation(Library.Compose.activity)
    implementation(Library.Compose.ui)
    implementation(Library.Compose.tooling)
    implementation(Library.Compose.compiler)
    implementation(Library.Compose.animation)
    implementation(Library.Compose.foundation)
    implementation(Library.Compose.foundationLayout)
    implementation(Library.Compose.material)
    implementation(Library.Compose.material3)
    implementation(Library.Compose.constraint)

    androidTestImplementation(Library.Accompanist.navigation)
    androidTestImplementation(Library.Accompanist.pager)
    androidTestImplementation(Library.Accompanist.pagerIndicators)
    androidTestImplementation(Library.Accompanist.systemUiController)


    androidTestImplementation(Library.Androidx.Test.testJunit)
    androidTestImplementation(Library.Androidx.Test.testRules)
    androidTestImplementation(Library.Androidx.Test.uiautomator)
    androidTestImplementation(Library.Androidx.Test.espresso)
    androidTestImplementation(Library.Compose.activity)
    androidTestImplementation(Library.Compose.composeUiTestJunit)
    androidTestImplementation(Library.turbine)
    androidTestImplementation(Library.Androidx.Test.testRunner)
    androidTestImplementation(composeBom)

    testImplementation(Library.mockk)
    testImplementation(Library.Androidx.Test.archCoreTest)
    androidTestImplementation(Library.Hilt.Test.hiltAndroidTest)
    kaptAndroidTest(Library.Hilt.compiler)

    implementation(platform(Library.Firebase.firebaseBillOfMaterials))
    implementation(Library.Firebase.firebaseConfig)
    implementation(Library.Firebase.firebaseAnalytics)

    implementation(Library.Androidx.preferenceDataStore)
}