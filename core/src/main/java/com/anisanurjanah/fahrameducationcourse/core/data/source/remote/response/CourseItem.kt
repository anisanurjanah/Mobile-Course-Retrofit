package com.anisanurjanah.fahrameducationcourse.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class CourseItem(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("level")
	val level: String,

	@field:SerializedName("module")
	val module: Int,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("teacherimage")
	val teacherImage: String,

	@field:SerializedName("path")
	val path: String,

	@field:SerializedName("view")
	val view: Int,

	@field:SerializedName("teacher")
	val teacher: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("excerpt")
	val excerpt: String,

	@field:SerializedName("published_at")
	val publishedAt: String,

	@field:SerializedName("slug")
	val slug: String
)
