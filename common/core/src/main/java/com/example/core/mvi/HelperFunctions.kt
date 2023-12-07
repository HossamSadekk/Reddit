package com.example.core.mvi

import com.example.core.use_case.DataState

suspend fun <T : Any> apiCall(call: suspend () -> T): DataState<T> {
    return try {
        val response = call()
        DataState.Success(response)
    } catch (ex: Throwable) {
        DataState.Error(ex)
    }
}