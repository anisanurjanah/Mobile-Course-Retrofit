package com.anisanurjanah.fahrameducationcourse.core.data.source.remote.network

import com.anisanurjanah.fahrameducationcourse.core.data.source.remote.response.article.ListArticleResponse
import com.anisanurjanah.fahrameducationcourse.core.data.source.remote.response.course.ListCourseResponse
import retrofit2.http.GET

interface ApiService {
    @GET("v2/courses")
    suspend fun getListCourse(): ListCourseResponse

    @GET("v2/posts")
    suspend fun getListArticle(): ListArticleResponse
}