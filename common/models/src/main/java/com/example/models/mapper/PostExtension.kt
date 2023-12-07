package com.example.models.mapper

import com.example.models.domainModels.Post
import com.example.models.local.PostEntity
import com.example.models.remote.Children
import com.example.models.remote.DataX
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun List<Children>.toPostsList(): List<Post> = map {
    it.data.toArticle()
}

fun List<Children>.toArticlesEntityList(): List<PostEntity> = map {
    it.data.toArticleEntity()
}

fun List<PostEntity>.toPostsDomain(): List<Post> = map {
    it.toPost()
}

fun Flow<List<PostEntity>>.mapToPostListFlow(): Flow<List<Post>> {
    return map { it.toPostsDomain() }
}

fun PostEntity.toPost(): Post = Post(
    id = id,
    author = author,
    description = description,
    title = title,
    image = image,
    score = score,
    url = url,
    numComments = numComments
)

fun DataX.toArticle(): Post = Post(
    id = id,
    author = author,
    description = selftext,
    title = title,
    image = " ",
    score = score,
    url = permalink,
    numComments = numComments
)

fun DataX.toArticleEntity(): PostEntity = PostEntity(
    id = id,
    author = author,
    description = selftext,
    title = title,
    image = " ",
    score = score,
    url = permalink,
    numComments = numComments
)