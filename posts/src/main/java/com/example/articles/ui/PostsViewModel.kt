package com.example.articles.ui

import com.example.articles.domain.use_case.GetPostsUseCase
import com.example.articles.domain.use_case.RefreshPostsUseCase
import com.example.core.connection.ConnectivityChecker
import com.example.core.mvi.BaseViewState
import com.example.core.mvi.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
    private val refreshPostsUseCase: RefreshPostsUseCase,
    private val connectivityChecker: ConnectivityChecker // Inject the connectivity checker
) :
    MviViewModel<BaseViewState<PostsScreenViewState>, PostsScreenEvent>() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _noInternetEvent = MutableSharedFlow<Unit>()
    val noInternetEvent: SharedFlow<Unit> = _noInternetEvent

    init {
        onTriggerEvent(PostsScreenEvent.LoadPostsList)
    }

    override fun onTriggerEvent(eventType: PostsScreenEvent) {
        when (eventType) {
            is PostsScreenEvent.LoadPostsList -> {
                getPosts()
            }

            is PostsScreenEvent.RefreshScreen -> {
                refreshScreen()
            }
        }
    }

    private fun getPosts(force: Boolean = false) = safeLaunch {
        if (force) {
            refreshPostsUseCase.invoke()
        } else {
            startLoading()
        }
        getPostsUseCase()
            .onEach {
                setState(
                    BaseViewState.Data(
                        PostsScreenViewState(
                            posts = it
                        )
                    )
                )
                _isLoading.value = false
            }
            .onCompletion { }
            .launchIn(this)

    }

    private fun refreshScreen() = safeLaunch {
        if (connectivityChecker.isConnected()) {
            _isLoading.value = true
            getPosts(force = true)
        } else {
            _noInternetEvent.emit(Unit)
        }
    }


    override fun handleError(exception: Throwable) {
        _isLoading.value = false
        Timber.e("PostsViewModel Exception -> $exception")
        if (exception is UnknownHostException) {
            val error = Exception("Check your internet and try again!")
            setState(BaseViewState.Error(error))
        } else {
            setState(BaseViewState.Error(exception))
        }
    }

}