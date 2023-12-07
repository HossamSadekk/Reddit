package com.example.articles.ui

import android.util.Log
import com.example.articles.domain.use_case.GetPostsUseCase
import com.example.core.mvi.BaseViewState
import com.example.core.mvi.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(private val getPostsUseCase: GetPostsUseCase) :
    MviViewModel<BaseViewState<PostsScreenViewState>, PostsScreenEvent>() {

    init {
        getPosts()
    }

    override fun onTriggerEvent(eventType: PostsScreenEvent) {
        when (eventType) {
            is PostsScreenEvent.LoadPostsList -> {}
            is PostsScreenEvent.RefreshScreen -> {}
        }
    }

    fun getPosts() = safeLaunch {
        startLoading()
        getPostsUseCase().onEach {

            Log.d("hossam", it?.size.toString())
            setState(
                BaseViewState.Data(
                    PostsScreenViewState(
                        posts = it
                    )
                )
            )

        }.launchIn(this)
    }

    override fun handleError(exception: Throwable) {
        Timber.e("PostsViewModel Exception -> $exception")
        setState(BaseViewState.Error(exception))
    }

}