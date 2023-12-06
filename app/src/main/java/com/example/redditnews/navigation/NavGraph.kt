package com.example.redditnews.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.articles.nav.articlesGraph
import com.example.core.navigation.Articles

@Composable
fun MainNavigation(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        startDestination = Articles.ARTICLESGRAPH
    ) {
        articlesGraph(navHostController)
    }
}