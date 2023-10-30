plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.moko.multiplatform)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
               implementation(libs.moko.resources)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        val androidMain by getting {
            dependsOn(commonMain)
        }
    }
}

android {
    namespace = "com.example.crowdin_sync_centralized"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "com.example.crowdin_sync_centralized"
    multiplatformResourcesClassName = "SharedRes"
}

