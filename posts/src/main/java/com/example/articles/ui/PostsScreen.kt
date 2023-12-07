package com.example.articles.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.mvi.BaseViewState

@Composable
fun PostsScreen(
    viewModel: PostsViewModel = hiltViewModel(),
    ){

    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    when (uiState.value) {
        is BaseViewState.Data -> {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
                Text(text = "DATA")
            }
        }
        is BaseViewState.Empty -> {}
        is BaseViewState.Error -> {
            Log.d("hossam","ERROR")
        }
        is BaseViewState.Loading -> {
            Log.d("hossam","LOADING")
        }
    }
}