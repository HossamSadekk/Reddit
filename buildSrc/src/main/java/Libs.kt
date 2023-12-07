object SupportLib {
    const val CoreKtx = "androidx.core:core-ktx:1.9.0"
    const val LifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1"
    const val LifecycleRuntimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:2.6.0-beta01"
    const val ActivityCompose = "androidx.activity:activity-compose:1.7.0"
    const val compose_ui = "androidx.compose.ui:ui"
    const val compose_graphics = "androidx.compose.ui:ui-graphics"
    const val compose_preview = "androidx.compose.ui:ui-tooling-preview"
    const val compose_material3 = "androidx.compose.material3:material3"
    const val material = "com.google.android.material:material:1.8.0"
    const val appcompat = "androidx.appcompat:appcompat:1.6.1"

}
object TestingLib {
    const val Junit = "junit:junit:4.13.2"
}

object AndroidTestingLib {
    const val JunitExt = "androidx.test.ext:junit:1.1.5"
    const val EspressoCore = "androidx.test.espresso:espresso-core:3.5.1"
    const val compose_junit4 = "androidx.compose.ui:ui-test-junit4"
}

object AndroidComposeDebugLib {
    const val ComposeUiTooling = "androidx.compose.ui:ui-tooling"
    const val UiTestManifest = "androidx.compose.ui:ui-test-manifest"
}

object Navigation {
    const val NavigationCompose = "androidx.navigation:navigation-compose:2.7.5"
}
object DI {
    const val Hilt = "com.google.dagger:hilt-android:2.44"
    const val Hilt_Compiler = "com.google.dagger:hilt-android-compiler:2.44"
    const val Hilt_Navigation = "androidx.hilt:hilt-navigation-compose:1.0.0"
}
object Local {
    const val Preferences_DataStore = "androidx.datastore:datastore-preferences:1.0.0"
    const val room = "androidx.room:room-runtime:2.5.2"
    const val room_compiler = "androidx.room:room-compiler:2.5.2"
    const val room_ktx = "androidx.room:room-ktx:2.5.0"
}

object Remote {
    const val retrofit2 = "com.squareup.retrofit2:retrofit:2.7.2"
    const val retrofit2_converter = "com.squareup.retrofit2:converter-gson:2.7.2"
    const val okhttp3 = "com.squareup.okhttp3:okhttp:3.6.0"
}

object Modules {
    const val ARTICLES = ":posts"
    const val ARTICLES_DETAILS = ":articleDetails"
    const val COMMON = ":common"
    const val MODELS = ":common:models"
    const val REMOTE = ":common:remote"
    const val CORE = ":common:core"
    const val LOCAL = ":common:local"
}
object Logger {
    const val Timber = "com.jakewharton.timber:timber:5.0.1"
}

object SwipeRefresh {
    const val swiperefresh = "com.google.accompanist:accompanist-swiperefresh:0.25.1"
}