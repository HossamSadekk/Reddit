pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Reddit News"
include(":app")
include(":posts")
include(":common")
include(":common:models")
include(":common:remote")
include(":common:core")
include(":common:local")
