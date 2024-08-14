package com.anisanurjanah.fahrameducationcourse.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anisanurjanah.fahrameducationcourse.core.data.source.local.entity.CourseEntity

@Database(entities = [CourseEntity::class],
    version = 1,
    exportSchema = false)
abstract class CourseDatabase : RoomDatabase() {

    abstract fun courseDao(): CourseDao

}