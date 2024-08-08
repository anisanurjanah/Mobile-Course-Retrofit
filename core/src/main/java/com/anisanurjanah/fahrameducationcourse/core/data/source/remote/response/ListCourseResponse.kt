package com.anisanurjanah.fahrameducationcourse.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListCourseResponse(

    @field:SerializedName("data")
    val data: List<CourseItem>
)