package com.anisanurjanah.fahrameducationcourse.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.anisanurjanah.fahrameducationcourse.core.domain.usecase.CourseUseCase

class FavoriteViewModel(courseUseCase: CourseUseCase) : ViewModel() {
    val favoriteCourse = courseUseCase.getFavoriteCourse().asLiveData()
}