package com.example.redditnews.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.articles.nav.postsGraph
import com.example.core.navigation.Posts

@Composable
fun MainNavigation(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        startDestination = Posts.POSTSGRAPH
    ) {
        postsGraph(navHostController)
    }
}