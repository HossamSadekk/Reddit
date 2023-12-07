package com.example.articles.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.articles.ui.PostsScreen
import com.example.core.navigation.Posts

fun NavGraphBuilder.postsGraph(
    navHostController: NavHostController
) {
    navigation(
        startDestination = Posts.POSTSLIST,
        route = Posts.POSTSGRAPH
    ) {
        composable(
            route = Posts.POSTSLIST
        ) {
            PostsScreen()
        }
    }
}