// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
}

/*buildscript {
    dependencies {
        classpath (libs.hilt.android.gradle.plugin) // or latest version
    }
}*/

buildscript {
    repositories{
        google()
        mavenCentral()
    }
    dependencies {
        classpath (libs.gradle )
        classpath (libs.kotlin.gradle.plugin)
        classpath (libs.hilt.android.gradle.plugin)
    }
}