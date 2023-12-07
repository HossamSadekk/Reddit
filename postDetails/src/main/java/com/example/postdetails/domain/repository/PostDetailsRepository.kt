package com.example.postdetails.domain.repository

import com.example.core.use_case.QueryPostParameter
import com.example.models.domainModels.Post

interface PostDetailsRepository {
    suspend fun getPost(parameters: QueryPostParameter): Post
}