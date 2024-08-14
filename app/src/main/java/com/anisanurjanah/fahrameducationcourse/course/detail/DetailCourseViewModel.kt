package com.anisanurjanah.fahrameducationcourse.course.detail

import androidx.lifecycle.ViewModel
import com.anisanurjanah.fahrameducationcourse.core.domain.model.Course
import com.anisanurjanah.fahrameducationcourse.core.domain.usecase.CourseUseCase

class DetailCourseViewModel(private val courseUseCase: CourseUseCase) : ViewModel() {
    fun setFavoriteCourse(course: Course, newStatus:Boolean) =
        courseUseCase.setFavoriteCourse(course, newStatus)
}
