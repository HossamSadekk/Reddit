package com.example.articles.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.articles.ui.component.PostsScreenContent
import com.example.core.components.AppBar
import com.example.core.components.ErrorView
import com.example.core.components.ProgressIndicator
import com.example.core.mvi.BaseViewState
import com.example.core.util.cast

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostsScreen(
    viewModel: PostsViewModel = hiltViewModel(),
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            AppBar(
                title = "Kotlin News"
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            when (uiState) {
                is BaseViewState.Data -> {
                    PostsScreenContent(uiState.cast<BaseViewState.Data<PostsScreenViewState>>().value)
                }

                is BaseViewState.Empty -> {

                }

                is BaseViewState.Error -> {
                    ErrorView(uiState.cast<BaseViewState.Error>().throwable.localizedMessage) {
                        viewModel.onTriggerEvent(PostsScreenEvent.RefreshScreen)
                    }
                }

                is BaseViewState.Loading -> {
                    ProgressIndicator()
                }
            }
        }
    }


}