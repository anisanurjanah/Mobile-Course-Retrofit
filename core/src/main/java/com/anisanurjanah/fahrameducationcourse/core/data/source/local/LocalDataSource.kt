package com.anisanurjanah.fahrameducationcourse.core.data.source.local

import com.anisanurjanah.fahrameducationcourse.core.data.source.local.entity.CourseEntity
import com.anisanurjanah.fahrameducationcourse.core.data.source.local.room.CourseDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val courseDao: CourseDao) {

    fun getAllCourse(): Flow<List<CourseEntity>> = courseDao.getAllCourse()

    fun getFavoriteCourse(): Flow<List<CourseEntity>> = courseDao.getFavoriteCourse()

    suspend fun insertCourse(courseList: List<CourseEntity>) = courseDao.insertCourse(courseList)

    fun setFavoriteCourse(courseEntity: CourseEntity, newState: Boolean) {
        courseEntity.isFavorite = newState
        courseDao.updateFavoriteCourse(courseEntity)
    }

}