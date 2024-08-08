package com.anisanurjanah.fahrameducationcourse.core.data.source.local.room

import androidx.room.*
import com.anisanurjanah.fahrameducationcourse.core.data.source.local.entity.CourseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {

    @Query("SELECT * FROM course")
    fun getAllCourse(): Flow<List<CourseEntity>>

    @Query("SELECT * FROM course where isFavorite = 1")
    fun getFavoriteCourse(): Flow<List<CourseEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourse(course: List<CourseEntity>)

    @Update
    fun updateFavoriteCourse(course: CourseEntity)
}