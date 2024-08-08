package com.anisanurjanah.fahrameducationcourse.core.domain.usecase

import com.anisanurjanah.fahrameducationcourse.core.domain.model.Course
import com.anisanurjanah.fahrameducationcourse.core.domain.repository.ICourseRepository

class CourseInteractor(private val courseRepository: ICourseRepository): CourseUseCase {

    override fun getAllCourse() = courseRepository.getAllCourse()

    override fun getFavoriteCourse() = courseRepository.getFavoriteCourse()

    override fun setFavoriteCourse(course: Course, state: Boolean) = courseRepository.setFavoriteCourse(course, state)
}