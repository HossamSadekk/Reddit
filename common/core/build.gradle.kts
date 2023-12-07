plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id ("kotlin-kapt")

}

android {
    namespace = "com.example.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(SupportLib.CoreKtx)
    implementation(SupportLib.LifecycleRuntime)
    implementation(SupportLib.ActivityCompose)
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation(SupportLib.compose_ui)
    implementation(SupportLib.compose_graphics)
    implementation(SupportLib.compose_preview)
    implementation(SupportLib.compose_material3)
    implementation("androidx.compose.ui:ui-graphics-android:1.5.4")
    // testing
    testImplementation(TestingLib.Junit)
    testImplementation(AndroidTestingLib.JunitExt)
    testImplementation(AndroidTestingLib.EspressoCore)
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation(AndroidTestingLib.compose_junit4)
    debugImplementation(AndroidComposeDebugLib.ComposeUiTooling)
    debugImplementation(AndroidComposeDebugLib.UiTestManifest)
    // logger
    implementation(Logger.Timber)
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation(DI.Hilt)
    kapt(DI.Hilt_Compiler)
    implementation(DI.Hilt_Navigation)

}