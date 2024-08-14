package com.anisanurjanah.fahrameducationcourse.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val articleId: Int,
    val title: String,
    val image: String,
    val excerpt: String,
    val author: String,
    val authorImage: String,
    val slug: String,
    var view: Int,
    val category: String,
    val publishedAt: String
) : Parcelable
