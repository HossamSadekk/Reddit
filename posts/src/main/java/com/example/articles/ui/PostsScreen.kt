package com.example.articles.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.articles.ui.component.PostsScreenContent
import com.example.core.components.AppBar
import com.example.core.components.ErrorView
import com.example.core.components.ProgressIndicator
import com.example.core.mvi.BaseViewState
import com.example.core.util.cast
import com.example.models.domainModels.Post
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostsScreen(
    viewModel: PostsViewModel = hiltViewModel(),
    onDetailClick: (post: Post) -> Unit = {}
) {
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val isRefreshing by viewModel.isLoading.collectAsStateWithLifecycle()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = isRefreshing)
    val noInternetEvent = rememberUpdatedState(viewModel.noInternetEvent)


    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = { viewModel.onTriggerEvent(PostsScreenEvent.RefreshScreen) },
        modifier = Modifier
            .fillMaxSize()
    ) {
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
                        PostsScreenContent(uiState.cast<BaseViewState.Data<PostsScreenViewState>>().value) {
                            onDetailClick(it)
                        }
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
            LaunchedEffect(noInternetEvent.value) {
                noInternetEvent.value.collect {
                    // Show Toast when there's no internet
                    Toast.makeText(
                        context,
                        "No internet connection",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }


}