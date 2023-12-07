package com.example.articles.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.articles.ui.PostsScreenViewState

@Composable
fun PostsScreenContent(
    uiState: PostsScreenViewState
){
    val posts = uiState.posts
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 90.dp)
    ){
        items(count = posts.size) {
            posts[it]?.let {
                PostRow(it)
            }
        }
    }
}