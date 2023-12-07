package com.example.postdetails.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.components.AppBar
import com.example.core.components.AppBarWithBackIcon
import com.example.postdetails.R
import com.example.postdetails.ui.PostDetailsScreenViewState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostDetailsContents(
    uiState: PostDetailsScreenViewState,
    onBackPressed: () -> Unit
){
    Scaffold(
        topBar = {
            AppBarWithBackIcon(
                title = uiState.posts.title,
                onBackClick = {onBackPressed.invoke()},
                backIcon = R.drawable._arrow_back
            )
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(paddingValues)){
           item {
               Column(
                   modifier = Modifier.fillMaxSize()
                       .background(color = MaterialTheme.colorScheme.background),
                   verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.CenterHorizontally
               ){
                   Text(
                       text = uiState.posts.title,
                       style = MaterialTheme.typography.headlineMedium,
                       color = MaterialTheme.colorScheme.inversePrimary,
                       textAlign = TextAlign.Center,
                       fontSize = 25.sp,
                       lineHeight = 40.sp,
                       maxLines = 2,
                       overflow = TextOverflow.Ellipsis
                   )
                   Spacer(modifier = Modifier.height(15.dp))
                   Text(
                       modifier = Modifier.fillMaxHeight().padding(start = 3.dp, end = 3.dp),
                       text = uiState.posts.description ?: "",
                       style = MaterialTheme.typography.bodyMedium,
                       color = MaterialTheme.colorScheme.onSecondary,
                   )

               }
           }
        }
    }
}