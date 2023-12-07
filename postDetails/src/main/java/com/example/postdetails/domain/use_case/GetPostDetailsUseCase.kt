package com.example.postdetails.domain.use_case

import com.example.core.mvi.apiCall
import com.example.core.use_case.DataState
import com.example.core.use_case.GetPostUseCase
import com.example.core.use_case.QueryPostParameter
import com.example.models.domainModels.Post
import com.example.postdetails.domain.repository.PostDetailsRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class GetPostDetailsUseCase
@Inject constructor(private val repository: PostDetailsRepository) : GetPostUseCase<Post>() {
    override suspend fun FlowCollector<DataState<Post>>.execute(parameter: QueryPostParameter?) {
        val post = repository.getPost(parameter ?: QueryPostParameter())
        val serviceCall = apiCall { post }
        emit(serviceCall)
    }


}