package com.example.postdetails.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.components.ErrorView
import com.example.core.components.ProgressIndicator
import com.example.core.mvi.BaseViewState
import com.example.core.util.cast
import com.example.postdetails.ui.components.PostDetailsContents

@Composable
fun PostDetailsScreen(
    viewModel: PostDetailsViewModel = hiltViewModel(),
    onBackPressed: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        when (uiState) {
            is BaseViewState.Data -> {
                PostDetailsContents(uiState.cast<BaseViewState.Data<PostDetailsScreenViewState>>().value)
                {
                    // on Back button
                    onBackPressed.invoke()
                }
            }

            is BaseViewState.Empty -> {

            }

            is BaseViewState.Error -> {
                ErrorView(uiState.cast<BaseViewState.Error>().throwable.localizedMessage) {
                    viewModel.onTriggerEvent(PostsDetailsScreenEvent.RefreshScreen)
                }
            }

            is BaseViewState.Loading -> {
                ProgressIndicator()
            }
        }
    }
}