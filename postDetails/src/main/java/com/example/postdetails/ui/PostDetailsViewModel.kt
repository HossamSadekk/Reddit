package com.example.postdetails.ui

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.example.core.mvi.BaseViewState
import com.example.core.mvi.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) :
    MviViewModel<BaseViewState<PostDetailsScreenViewState>, PostsDetailsScreenEvent>() {

    init {
        val id = savedStateHandle.get<String>("PostId")
        if (id != null) {
            // call api
        }
    }
        override fun onTriggerEvent(eventType: PostsDetailsScreenEvent) {
            when (eventType) {
                is PostsDetailsScreenEvent.LoadPostDetails -> {}
                is PostsDetailsScreenEvent.RefreshScreen -> {}
            }
        }

        override fun handleError(exception: Throwable) {
            TODO("Not yet implemented")
        }
    }