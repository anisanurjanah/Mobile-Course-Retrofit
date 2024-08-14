package com.anisanurjanah.fahrameducationcourse.core.utils

import com.anisanurjanah.fahrameducationcourse.core.data.source.local.entity.CourseEntity
import com.anisanurjanah.fahrameducationcourse.core.data.source.remote.response.course.CourseItem
import com.anisanurjanah.fahrameducationcourse.core.domain.model.Course

object DataMapper {
    fun mapResponsesToEntities(input: List<CourseItem>): List<CourseEntity> {
        val courseList = ArrayList<CourseEntity>()
        input.map {
            val course = CourseEntity(
                courseId = it.id,
                title = it.title,
                image = it.image,
                excerpt = it.excerpt,
                teacher = it.teacher,
                teacherImage = it.teacherImage,
                path = it.path,
                slug = it.slug,
                view = it.view,
                level = it.level,
                module = it.module,
                publishedAt = it.publishedAt,
                isFavorite = false
            )
            courseList.add(course)
        }
        return courseList
    }

    fun mapEntitiesToDomain(input: List<CourseEntity>): List<Course> =
        input.map {
            Course(
                courseId = it.courseId,
                title = it.title,
                image = it.image,
                excerpt = it.excerpt,
                teacher = it.teacher,
                teacherImage = it.teacherImage,
                path = it.path,
                slug = it.slug,
                view = it.view,
                level = it.level,
                module = it.module,
                publishedAt = it.publishedAt,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Course) = CourseEntity(
        courseId = input.courseId,
        title = input.title,
        image = input.image,
        excerpt = input.excerpt,
        teacher = input.teacher,
        teacherImage = input.teacherImage,
        path = input.path,
        slug = input.slug,
        view = input.view,
        level = input.level,
        module = input.module,
        publishedAt = input.publishedAt,
        isFavorite = input.isFavorite
    )
}