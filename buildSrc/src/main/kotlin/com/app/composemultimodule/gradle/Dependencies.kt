package com.app.composemultimodule.gradle

import java.io.File
import java.util.concurrent.TimeUnit
import kotlin.jvm.Throws

object Android {
    const val minSdk = 26
    const val compileSdk = 34
    const val targetSdk = 34
    const val buildTools = "34.0.0"
    const val versionMajor = 1
    const val versionMinor = 0
    const val versionPatch = 0

    /**
     * Execute
     *
     * @param workingDir
     * @return String
     */
    @Synchronized
    @Throws(Exception::class)
    fun String.execute(workingDir: File): String = try {
        val parts = split("\\s".toRegex())
        val process = ProcessBuilder(*parts.toTypedArray())
            .directory(workingDir)
            .redirectOutput(ProcessBuilder.Redirect.PIPE)
            .redirectError(ProcessBuilder.Redirect.PIPE)
            .start()

        process.waitFor(1,TimeUnit.MINUTES)
        process.inputStream.bufferedReader().readText()
    } catch (e:Exception){
        throw e
    }

    /**
     * version build
     * @param workingDir
     * @return total commit count as Int
     */
    fun versionBuild(workingDir: File = File(".")) = try {
        "git rev-list --count HEAD".execute(workingDir).trim().toInt()
    } catch (e:Exception){
        0 //default value required for initial times when there is no commit to github
    }
}

object Version {
    const val ndkVersion = "25.2.9519653"
    const val material = "1.8.0"
    const val coil = "2.3.0"
    const val coilCompose = "2.5.0"
    const val ktor = "2.3.0"
    const val junit = "4.13.2"
    const val kotlin = "1.9.20"
    const val gradlePlugin = "7.4.2"
    const val mockk = "1.13.5"
    const val coroutines = "1.6.4"
    const val leakcanary = "2.10"
    const val composeBom = "2023.05.01"
    const val composeCompiler = "1.5.5"
    const val activityCompose = "1.7.2"
    const val balloon = "1.6.4"
    const val constraintCompose = "1.0.1"
    const val diktat = "1.0.3"
    const val spotless = "6.6.1"
    const val kover = "0.5.0"
    const val ktlint = "0.44.0"
    const val accompanist = "0.32.0"
    const val compatibility = "0.13.0"
    const val hilt = "2.46"
    const val turbine = "0.12.0"
    const val store4 = "4.0.5"
    const val networking = "1.8.0"
    const val googlePlayServicesTasks = "18.0.2"
    const val googlePlayServicesLocation = "21.0.1"
    const val googleGmsServices = "4.3.15"
    const val kotlinxSerialization = "1.5.0"
    const val kotlinxCollections = "0.3.5"
    const val firebaseBom = "31.5.0"
    const val firebaseCrashlyticsPlugin = "2.9.4"
    const val javalite = "3.22.3"
    const val hiltWorkManager = "1.0.0"
    const val gson = "2.10.1"

    object Androidx {
        const val testJunit = "1.1.5"
        const val testUiAutomator = "2.3.0-alpha02"
        const val coreTest = "2.2.0"
        const val testRules = "1.5.0"
        const val testRunner = "1.5.2"
        const val annotation = "1.6.0"
        const val lifecycle = "2.6.1"
        const val appStartup = "1.1.1"
        const val navigation = "2.6.0-alpha09"
        const val coreKtx = "1.9.0"
        const val hiltNavigationCompose = "1.0.0"
        const val espresso = "3.5.1"
        const val work = "2.8.1"
        const val splash = "1.0.0"
        const val dataStore = "1.0.0"
        const val preference = "1.2.0"
        const val paging = "3.1.1"
        const val pagingCompose = "1.0.0-alpha20"
    }
}

@Suppress("WRONG_ORDER_IN_CLASS_LIKE_STRUCTURES")
object Library {
    object Plugin {
        const val androidGradle = "com.android.tools.build:gradle:${Version.gradlePlugin}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Version.hilt}"
        const val navigationSaveArg = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.Androidx.navigation}"
        object Id {
            const val navigationSaveArg = "androidx.navigation.safeargs.kotlin"
        }
        const val googleGmsServices = "com.google.gms:google-services:${Version.googleGmsServices}"
    }
    object Androidx {
        object Test {
            const val testJunit = "androidx.test.ext:junit:${Version.Androidx.testJunit}"
            const val testRules = "androidx.test:Rules:${Version.Androidx.testRules}"
            const val archCoreTest = "androidx.arch.core:core-testing:${Version.Androidx.coreTest}"
            const val uiautomator = "androidx.test.uiautomator:uiautomator:${Version.Androidx.testUiAutomator}"
            const val espresso = "androidx.test.espresso:espresso-core:${Version.Androidx.espresso}"
            const val testRunner = "androidx.test:runner:${Version.Androidx.testRunner}"
        }
        const val startup = "androidx.startup:startup-runtime:${Version.Androidx.appStartup}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.Androidx.lifecycle}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.Androidx.lifecycle}"
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.Androidx.lifecycle}"
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.Androidx.lifecycle}"
        const val lifecycleRuntimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:${Version.Androidx.lifecycle}"
        const val annotation = "androidx.annotation:annotation:${Version.Androidx.annotation}"
        const val coreKtx = "androidx.core:core-ktx:${Version.Androidx.coreKtx}"
        const val navigationCompose = "androidx.navigation:navigation-compose:${Version.Androidx.navigation}"
        const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Version.Androidx.hiltNavigationCompose}"
        const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Version.Androidx.navigation}"
        const val navigationTesting = "androidx.navigation:navigation-testing:${Version.Androidx.navigation}"
        const val workRuntime = "androidx.work:work-runtime:${Version.Androidx.work}"
        const val workRuntimeKtxExt = "androidx.work:work-runtime-ktx:${Version.Androidx.work}"
        const val splash = "androidx.core:core-splashscreen:${Version.Androidx.splash}"
        const val protobuDataStore = "androidx.datastore:datastore:${Version.Androidx.dataStore}"
        const val preferenceDataStore = "androidx.datastore:datastore-preferences:${Version.Androidx.dataStore}"
        const val preference = "androidx.preference:preference:${Version.Androidx.preference}"
        const val paging = "androidx.paging:paging-runtime:${Version.Androidx.paging}"
        const val pagingCompose = "androidx.paging:paging-compose:${Version.Androidx.pagingCompose}"
        const val hiltWorkManager = "androidx.hilt:hilt-work:${Version.hiltWorkManager}"
        const val hiltWorkManagerCompiler = "androidx.hilt:hilt-compiler:${Version.hiltWorkManager}"
    }

    object Compose {
        const val composeBillOfMaterials = "androidx.compose:compose-bom:${Version.composeBom}"
        const val ui = "androidx.compose.ui:ui"
        const val tooling = "androidx.compose.ui:ui-tooling"
        const val toolingPreview = "androidx.compose.ui:ui-tooling-preview"
        const val animation = "androidx.compose.animation:animation"
        const val foundation = "androidx.compose.foundation:foundation"
        const val foundationLayout = "androidx.compose.foundation:foundation-layout"
        const val material = "androidx.compose.material:material"
        const val material3 = "androidx.compose.material3:material3"
        const val composeUiTestJunit = "androidx.compose.ui:ui-test-junit4"

        const val compiler = "androidx.compose.compiler:compiler:${Version.composeCompiler}"
        const val activity = "androidx.activity:activity-compose:${Version.activityCompose}"
        const val balloon = "com.github.skydoves:balloon-compose:${Version.balloon}"
        const val constraint = "androidx.constraintlayout:constraintlayout-compose:${Version.constraintCompose}"
    }

    object GooglePlayServices {
        const val location = "com.google.android.gms:play-services-location:${Version.googlePlayServicesLocation}"
        const val gmsTasks = "com.google.android.gms:play-services-tasks:${Version.googlePlayServicesTasks}"
    }

    const val junit = "junit:junit:${Version.junit}"
    const val mockk = "io.mockk:mockk:${Version.mockk}"
    const val turbine = "app:cash.turbine:turbine:${Version.turbine}"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutines}"
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:${Version.leakcanary}"

    object kotlin {
        const val kotlinStdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlin}"
        const val coroutinePlayServices = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Version.coroutines}"
        const val kotlinxSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.kotlinxSerialization}"
        const val kotlinxCollections = "org.jetbrains.kotlinx:kotlinx-collections-immutable-jvm:${Version.kotlinxCollections}"
    }

    object Accompanist {
        const val navigation = "com.google.accompanist:accompanist-navigation-animation:${Version.accompanist}"
        const val pager = "com.google.accompanist:accompanist-pager:${Version.accompanist}"
        const val pagerIndicators = "com.google.accompanist:accompanist-pager-indicators:${Version.accompanist}"
        const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:${Version.accompanist}"
        const val flowLayout = "com.google.accompanist:accompanist-flowlayout:${Version.accompanist}"
        const val placeHolder = "com.google.accompanist:accompanist-placeholder-material:${Version.accompanist}"
    }

    object Material {
        const val material = "com.google.android.material:material:${Version.material}"
    }

    object Hilt {
        const val core = "com.google.dagger:hilt-android:${Version.hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Version.hilt}"
        object Test {
            const val hiltAndroidTest = "com.google.dagger:hilt-android-testing:${Version.hilt}"
        }
    }

    object Coil {
        const val core = "io.coil-kt:coil:${Version.coilCompose}"
        const val compose = "io.coil-kt:coil-compose:${Version.coil}"
    }

    object Ktor {
        const val okHttp = "io.ktor:ktor-client-okhttp:${Version.ktor}"
        const val core = "io.ktor:ktor-client-android:${Version.ktor}"
        const val json = "io.ktor:ktor-serialization-kotlinx-json:${Version.ktor}"
        const val serialization = "io.ktor:ktor-client-content-negotiation:${Version.ktor}"
        const val logging = "io.ktor:ktor-client-logging:${Version.ktor}"
        const val testing = "io.ktor:ktor-client-mock:${Version.ktor}"
    }

    object Gson {
        const val gson = "com.google.code.gson:gson:${Version.gson}"
    }

    object Dropbox {
        const val store4 = "com.dropbox.mobile.store:store4:${Version.store4}"
    }

    object Firebase {
        const val firebaseBillOfMaterials = "com.google.firebase:firebase-bom:${Version.firebaseBom}"
        const val firebaseConfig = "com.google.firebase:firebase-config"
        const val firebaseAnalytics = "com.google.firebase:firebase-analytics"
        const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-gradle"
    }
    object Proto {
        const val javalite = "com.google.protobuf:protobuf-javalite:${Version.javalite}"
    }

    object Okhttp {
        const val Logging = "com.squareup.okhttp3:logging-interceptor:4.11.0"
    }
}