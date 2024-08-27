package com.anisanurjanah.fahrameducationcourse.core.data.source.remote.response.article

import com.google.gson.annotations.SerializedName

data class ArticleItem(

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("author")
    val author: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("view")
    val view: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("authorimage")
    val authorImage: String? = null,

    @field:SerializedName("excerpt")
    val excerpt: String? = null,

    @field:SerializedName("category")
    val category: String? = null,

    @field:SerializedName("published_at")
    val publishedAt: String? = null,

    @field:SerializedName("slug")
    val slug: String? = null
)
