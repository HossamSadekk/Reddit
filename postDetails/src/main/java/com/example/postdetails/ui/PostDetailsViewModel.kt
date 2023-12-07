package com.example.postdetails.ui

import androidx.lifecycle.SavedStateHandle
import com.example.core.mvi.BaseViewState
import com.example.core.mvi.MviViewModel
import com.example.core.use_case.QueryPostParameter
import com.example.postdetails.domain.use_case.GetPostDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getPostUseCase: GetPostDetailsUseCase
) :
    MviViewModel<BaseViewState<PostDetailsScreenViewState>, PostsDetailsScreenEvent>() {
    private val id = savedStateHandle.get<String>("PostId")
    private val title = savedStateHandle.get<String>("PostTitle")

    init {
        if (id != null && title != null) {
            onTriggerEvent(
                PostsDetailsScreenEvent.LoadPostDetails(
                    QueryPostParameter(
                        post_id = id,
                        post_title = title
                    )
                )
            )
        }
    }

    override fun onTriggerEvent(eventType: PostsDetailsScreenEvent) {
        when (eventType) {
            is PostsDetailsScreenEvent.LoadPostDetails -> {
                getPostDetails(eventType.parameter)
            }

            is PostsDetailsScreenEvent.RefreshScreen -> {
                refreshScreen()
            }
        }
    }

    private fun getPostDetails(parameter: QueryPostParameter) = safeLaunch {
        startLoading()
        execute(getPostUseCase(parameter)) {
            setState(BaseViewState.Data(PostDetailsScreenViewState(posts = it)))
        }
    }

    private fun refreshScreen() {
        if (id != null && title != null) {
            getPostDetails(
                QueryPostParameter(
                    post_id = id,
                    post_title = title
                )
            )
        }
    }

    override fun handleError(exception: Throwable) {
        Timber.e("PostDetailsViewModel Exception -> $exception")
        if (exception is UnknownHostException) {
            val error = Exception("Check your internet and try again!")
            setState(BaseViewState.Error(error))
        } else {
            setState(BaseViewState.Error(exception))
        }
    }
}