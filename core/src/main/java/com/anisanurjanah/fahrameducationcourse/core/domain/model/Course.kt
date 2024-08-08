package com.anisanurjanah.fahrameducationcourse.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Course(
    val courseId: String,
    val title: String,
    val image: String,
    val excerpt: String,
    val teacher: String,
    val teacherImage: String,
    val path: String,
    val slug: String,
    var view: String,
    val level: String,
    val module: String,
    val publishedAt: String,
    var isFavorite: Boolean
) : Parcelable