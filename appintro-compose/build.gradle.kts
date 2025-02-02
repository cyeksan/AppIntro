plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.detekt)
    alias(libs.plugins.ktlint)
    id("maven-publish")
}

group = "com.github.AppIntro"
version = "7.0.0-beta02"

android {
    namespace = "com.github.appintro"
    compileSdk = libs.versions.compile.sdk.version.get().toInt()

    defaultConfig {
        minSdk = libs.versions.min.compose.sdk.version.get().toInt()

        consumerProguardFiles("consumer-proguard-rules.pro")
        vectorDrawables.useSupportLibrary = true
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
        warningsAsErrors = true
        abortOnError = true
        lint {
            disable.addAll(
                listOf(
                    "MissingTranslation",
                    "OldTargetApi",
                    "GradleDependency"
                )
            )
        }
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

    testImplementation(libs.junit)
    testImplementation(libs.mockito.core)
}

ktlint {
    debug.set(false)
    verbose.set(true)
    android.set(false)
    outputToConsole.set(true)
    ignoreFailures.set(false)
}

detekt {
    config.setFrom(files("./detekt-config.yml"))
}

val POM_NAME: String by project
val POM_DESCRIPTION: String by project
val POM_LICENSE_NAME: String by project
val POM_LICENSE_URL: String by project
val POM_SCM_CONNECTION: String by project
val POM_URL: String by project

publishing {
    publications {
        register<MavenPublication>("release") {
            afterEvaluate {
                from(components["release"])
            }
            pom {
                name.set(POM_NAME)
                description.set(POM_DESCRIPTION)
                url.set(POM_URL)
                licenses {
                    license {
                        name.set(POM_LICENSE_NAME)
                        url.set(POM_LICENSE_URL)
                    }
                }
                scm {
                    connection.set(POM_SCM_CONNECTION)
                    developerConnection.set(POM_SCM_CONNECTION)
                    url.set(POM_URL)
                }
                developers {
                    developer {
                        id.set("paolorotolo")
                        name.set("Paolo Rotolo")
                        email.set("paolo@rotolo.dev")
                    }
                    developer {
                        id.set("cortinico")
                        name.set("Nicola Corti")
                        email.set("corti.nico@gmail.com")
                    }
                }
            }
        }
    }
}
