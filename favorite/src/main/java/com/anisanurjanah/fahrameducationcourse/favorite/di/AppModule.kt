package com.anisanurjanah.fahrameducationcourse.favorite.di

import com.anisanurjanah.fahrameducationcourse.article.ArticleViewModel
import com.anisanurjanah.fahrameducationcourse.core.domain.usecase.CourseInteractor
import com.anisanurjanah.fahrameducationcourse.core.domain.usecase.CourseUseCase
import com.anisanurjanah.fahrameducationcourse.course.CourseViewModel
import com.anisanurjanah.fahrameducationcourse.course.detail.DetailCourseViewModel
import com.anisanurjanah.fahrameducationcourse.favorite.FavoriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<CourseUseCase> { CourseInteractor(get()) }
}

val viewModelModule = module {
//    viewModel { HomeViewModel(get()) }
    viewModel { CourseViewModel(get()) }
    viewModel { DetailCourseViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { ArticleViewModel(get()) }
}
