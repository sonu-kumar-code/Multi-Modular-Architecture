// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.1" apply false
    id("com.android.library") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
    id("com.google.dagger.hilt.android") version "2.46" apply false
    id("com.diffplug.spotless") version "6.6.1"
    id("org.cqfn.diktat.diktat-gradle-plugin") version "1.0.3"
    id("org.jetbrains.kotlinx.kover") version "0.5.0"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.20" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        val navigationSafeArg = com.app.composemultimodule.gradle.Library.Plugin.navigationSaveArg
        classpath(navigationSafeArg)
    }
}

val enableKover: Boolean = System.getProperty("enableKover","false")?.toBoolean() ?: false
val koverEngine:String? = System.getProperty("koverEngine",null)
val koverReportOnCheck:Boolean? = System.getProperty("koverReportOnCheck",null)?.toBoolean()
val koverIntellijEngineVersion:String? = System.getProperty("koverIntellijEngineVersion",null)
val koverJacocoEngineVersion:String? = System.getProperty("koverJacocoEngineVersion",null)
val diktatDebug:Boolean = System.getProperty("diktatDebug","false")?.toBoolean() ?: false

diktat{
    debug = diktatDebug
    inputs {
        include("**/*.kt")
        exclude(
            "**/src/androidTest/**",
            "**/src/test/**",
            "**/generated/source/apollo/**",
            "**/graphql/**"
        )
    }
}

kover {
    isDisabled = enableKover
    when(koverEngine){
        "jacoco" -> coverageEngine.set(kotlinx.kover.api.CoverageEngine.JACOCO)
        "intellij" -> coverageEngine.set(kotlinx.kover.api.CoverageEngine.INTELLIJ)
        else -> if (!koverEngine.isNullOrEmpty()){
            throw kotlin.Exception(
                "kover engine not supported $koverEngine"
            )
        }
    }

    koverReportOnCheck?.let {
        generateReportOnCheck = it
    }
    if (!koverJacocoEngineVersion.isNullOrEmpty()){
        jacocoEngineVersion.set(koverJacocoEngineVersion)
    }
    if (!koverIntellijEngineVersion.isNullOrEmpty()){
        intellijEngineVersion.set(koverIntellijEngineVersion)
    }
}

spotless {
    kotlin {
        target("**/*.kt")
        targetExclude(
            "**/src/main/kotlin/com/app/composemultimodule/gradle/**",
        )
        trimTrailingWhitespace()
        ktlint(com.app.composemultimodule.gradle.Version.ktlint)
            .userData(
                mapOf(
                    "disabled_rules" to "no-wildcard-imports,no-unused-imports"
                )
            )
    }
    kotlinGradle{
        target("*.gradle.kts","additionalScripts/*.gradle.kts")
        targetExclude(
            "build.gradle.kts",
        )
        trimTrailingWhitespace()
        ktlint(com.app.composemultimodule.gradle.Version.ktlint)
            .userData(
                mapOf(
                    "disabled_rules" to "no-wildcard-imports,no-unused-imports"
                )
            )
    }
}
allprojects {

    subprojects {
        val coverageIncludes = listOf("com.app.composemultimodule.*")

        val coverageExcludes = listOf(
            "*.BuildConfig",
            "*.*Application",
            "*.*Activity*",
            "*.*_Factory*",
            "*.*_HiltModules*",
            "*.*TestTags",
            "*.compose.*",
            "*Worker*",
            "**.graphql.**",
            "**.type.**",
        )
        tasks.withType<kotlinx.kover.tasks.KoverXmlReportTask>().all {
            includes = coverageIncludes
            excludes = coverageExcludes
        }
        tasks.withType<kotlinx.kover.tasks.KoverHtmlReportTask>().all {
            includes = coverageIncludes
            excludes = coverageExcludes
        }
    }
}