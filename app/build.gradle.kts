plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id("com.google.dagger.hilt.android")

}

android {
    namespace = "com.example.redditnews"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.redditnews"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
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
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // core
    implementation(SupportLib.CoreKtx)
    implementation(SupportLib.LifecycleRuntime)
    implementation(SupportLib.ActivityCompose)
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation(SupportLib.compose_ui)
    implementation(SupportLib.compose_graphics)
    implementation(SupportLib.compose_preview)
    implementation(SupportLib.compose_material3)
    // testing
    testImplementation(TestingLib.Junit)
    testImplementation(AndroidTestingLib.JunitExt)
    testImplementation(AndroidTestingLib.EspressoCore)
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation(AndroidTestingLib.compose_junit4)
    debugImplementation(AndroidComposeDebugLib.ComposeUiTooling)
    debugImplementation(AndroidComposeDebugLib.UiTestManifest)
    // di
    implementation(DI.Hilt)
    kapt(DI.Hilt_Compiler)
    implementation(DI.Hilt_Navigation)
    // navigation
    implementation(Navigation.NavigationCompose)
    // timber
    implementation(Logger.Timber)
    // MODULES
    implementation(project(Modules.ARTICLES))
    implementation(project(Modules.POST_DETAILS))
    implementation(project(Modules.CORE))

    debugImplementation(LeakMemory.LeakCanary)


}