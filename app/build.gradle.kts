import com.app.composemultimodule.gradle.Android
import com.app.composemultimodule.gradle.Library

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}
hilt{
    enableAggregatingTask = true
}

android {
    compileSdk = Android.compileSdk
    buildToolsVersion = Android.buildTools
    namespace = "com.app.composemultimodule"

    defaultConfig {
        applicationId = "com.app.composemultimodule"
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = 1
        versionName = "1.0"

        testApplicationId = "com.app.composemultimodule.testing"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testBuildType = System.getProperty("testBuildType","debug")
        resourceConfigurations += mutableSetOf(
            "en"
        )
        composeOptions {
            kotlinCompilerExtensionVersion = com.app.composemultimodule.gradle.Version.composeCompiler
        }
        buildFeatures {
            compose = true
        }
    }

    testOptions {
        unitTests {
            all {
                it.jvmArgs("-noverify")
            }
            tasks.withType<Test>().configureEach {
                maxParallelForks = (System.getenv("UNIT_TEST_MAX_PARALLEL_FORKS") ?: "16").toInt()
            }
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
    packaging {
        resources.excludes.add("META_INF/*")
        resources.excludes.add("META_INF/licenses/ASM")
        resources.excludes.add("META_INF/gradle/incremental.annotation.processors")
        resources.excludes += "win32-x86-64/attach_hotspot_windows.dll"
        resources.excludes += "win32-x86/attach_hotspot_windows.dll"
    }
}

dependencies {

    implementation(project(":app-navigation"))

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