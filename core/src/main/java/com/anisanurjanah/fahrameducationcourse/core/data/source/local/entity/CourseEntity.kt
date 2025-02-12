package com.anisanurjanah.fahrameducationcourse.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course")
data class CourseEntity(
    @PrimaryKey
    @ColumnInfo(name = "courseId")
    var courseId: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "excerpt")
    var excerpt: String,

    @ColumnInfo(name = "teacher")
    var teacher: String,

    @ColumnInfo(name = "teacherImage")
    var teacherImage: String,

    @ColumnInfo(name = "path")
    var path: String,

    @ColumnInfo(name = "slug")
    var slug: String,

    @ColumnInfo(name = "view")
    var view: Int,

    @ColumnInfo(name = "level")
    var level: String,

    @ColumnInfo(name = "module")
    var module: Int,

    @ColumnInfo(name = "publishedAt")
    var publishedAt: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)