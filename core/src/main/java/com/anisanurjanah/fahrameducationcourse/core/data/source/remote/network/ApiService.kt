package com.anisanurjanah.fahrameducationcourse.core.data.source.remote.network

import com.anisanurjanah.fahrameducationcourse.core.data.source.remote.response.ListCourseResponse
import retrofit2.http.GET

interface ApiService {
    @GET("v2/courses")
    suspend fun getList(): ListCourseResponse
}