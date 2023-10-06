plugins {
    alias(libs.plugins.application)
    kotlin("android")
}

android {
    compileSdk = libs.versions.compile.sdk.version.get().toInt()
    namespace = "com.github.appintro.composeexample"

    defaultConfig {
        minSdk = libs.versions.min.compose.sdk.version.get().toInt()
        targetSdk = libs.versions.target.sdk.version.get().toInt()

        vectorDrawables.useSupportLibrary = true
        applicationId = "com.github.appintro.composeexample"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
    lint {
        disable.addAll(
            listOf(
                "MissingTranslation",
                "OldTargetApi",
                "GradleDependency"
            )
        )
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)

    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.test)
    implementation(libs.androidx.compose.ui.testManifest)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.toolingPreview)
    implementation(libs.accompanist.pager)
    implementation(libs.androidx.navigation.compose)
    implementation(project(":appintro"))
}
