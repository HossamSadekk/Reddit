package com.example.models.mapper

import com.example.models.models.Article
import com.example.models.remote.Children
import com.example.models.remote.DataX

fun List<Children>.toArticlesList(): List<Article> = map{
it.data.toArticle()
}

fun DataX.toArticle():Article = Article(
    author = author,
    description = selftext,
    title = title,
    image = mediaMetadata.nlzfhabcmh4c1.p[2].u,
    score = score,
    url = permalink,
    numComments = numComments
)