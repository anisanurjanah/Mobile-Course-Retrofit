package com.anisanurjanah.fahrameducationcourse.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.anisanurjanah.fahrameducationcourse.core.domain.usecase.CourseUseCase

class ArticleViewModel(courseUseCase: CourseUseCase) : ViewModel() {
    val article = courseUseCase.getAllArticle().asLiveData()
}