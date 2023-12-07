package com.example.core.use_case

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

sealed class DataState<out T> {
    data class Success<out T>(val result: T) : DataState<T>()
    data class Error(val error: Throwable) : DataState<Nothing>()
}

abstract class GetPostUseCase<ReturnType> where ReturnType : Any {

    protected abstract suspend fun FlowCollector<DataState<ReturnType>>.execute(parameter: QueryPostParameter?=null)

    suspend operator fun invoke(parameter: QueryPostParameter? = null,) = flow {
        execute(parameter)
    }.flowOn(Dispatchers.IO)
}
data class QueryPostParameter(val post_id:String = "",val post_title : String = "")