plugins {
    `kotlin-dsl`
}

apply(from = "versions.gradle.kts")

repositories {
    mavenCentral()
    google()
}

dependencies {
    val versions = project.ext["versions"] as Map<*, *>
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${versions["kotlin"]}")
}