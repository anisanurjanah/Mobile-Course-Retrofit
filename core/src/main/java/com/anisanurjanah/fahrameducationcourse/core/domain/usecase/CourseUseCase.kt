package com.anisanurjanah.fahrameducationcourse.core.domain.usecase

import com.anisanurjanah.fahrameducationcourse.core.data.source.Resource
import com.anisanurjanah.fahrameducationcourse.core.domain.model.Article
import com.anisanurjanah.fahrameducationcourse.core.domain.model.Course
import kotlinx.coroutines.flow.Flow

interface CourseUseCase {

    fun getAllCourse(): Flow<Resource<List<Course>>>
    fun getFavoriteCourse(): Flow<List<Course>>
    fun setFavoriteCourse(course: Course, state: Boolean)
    fun getAllArticle(): Flow<Resource<List<Article>>>

}