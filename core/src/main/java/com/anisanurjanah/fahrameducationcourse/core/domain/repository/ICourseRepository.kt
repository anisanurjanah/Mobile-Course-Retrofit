package com.anisanurjanah.fahrameducationcourse.core.domain.repository

import com.anisanurjanah.fahrameducationcourse.core.data.source.Resource
import com.anisanurjanah.fahrameducationcourse.core.domain.model.Course
import kotlinx.coroutines.flow.Flow

interface ICourseRepository {

    fun getAllCourse(): Flow<Resource<List<Course>>>

    fun getFavoriteCourse(): Flow<List<Course>>

    fun setFavoriteCourse(course: Course, state: Boolean)

}