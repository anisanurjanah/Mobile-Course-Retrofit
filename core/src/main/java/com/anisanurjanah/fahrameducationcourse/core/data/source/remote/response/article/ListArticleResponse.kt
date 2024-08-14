package com.anisanurjanah.fahrameducationcourse.core.data.source.remote.response.article

import com.google.gson.annotations.SerializedName

data class ListArticleResponse(

	@field:SerializedName("data")
	val data: List<ArticleItem>
)
