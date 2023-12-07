package com.example.postdetails.data.repository

import com.example.core.use_case.QueryPostParameter
import com.example.models.domainModels.Post
import com.example.models.mapper.toArticle
import com.example.models.remote.PostResponse
import com.example.postdetails.domain.repository.PostDetailsRepository
import com.example.remote.service.RedditApi
import javax.inject.Inject

class PostDetailsRepositoryImpl @Inject constructor(
    private val api: RedditApi
) : PostDetailsRepository{
    override suspend fun getPost(parameter: QueryPostParameter): Post {
        val response = api.getPostDetails(postId = parameter.post_id, subreddit = parameter.post_title).get(0).data.children
        val post = response.get(0).data.toArticle()
        return post
    }

}