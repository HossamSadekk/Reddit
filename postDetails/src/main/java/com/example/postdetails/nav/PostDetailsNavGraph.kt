package com.example.postdetails.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import com.example.core.navigation.Posts.POSTDETAILS
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.postdetails.ui.PostDetailsScreen

fun NavGraphBuilder.postDetails(onNavigateBack: () -> Unit) {
    composable(POSTDETAILS + "/{PostId}/{PostTitle}",
        arguments = listOf(
            navArgument(
                name = "PostId",
            ) {
                type = NavType.StringType
            },
            navArgument(
                name = "PostTitle",
            ) {
                type = NavType.StringType
            }
        )
        ) { backStackEntry ->
        val PostId = backStackEntry.arguments?.getString("PostId")
        val PostTitle = backStackEntry.arguments?.getString("PostTitle")
        PostId?.let {
            PostDetailsScreen()
        }
    }
}