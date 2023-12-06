package com.example.articles.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.core.navigation.Articles

fun NavGraphBuilder.articlesGraph(
    navHostController: NavHostController
) {
    navigation(
        startDestination = Articles.ARTICLESlIST,
        route = Articles.ARTICLESGRAPH
    ) {
        composable(
            route = Articles.ARTICLESlIST
        ) {

        }


    }
}