package com.anisanurjanah.fahrameducationcourse.course

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.anisanurjanah.fahrameducationcourse.core.domain.usecase.CourseUseCase

class CourseViewModel(courseUseCase: CourseUseCase) : ViewModel() {
    val course = courseUseCase.getAllCourse().asLiveData()
}