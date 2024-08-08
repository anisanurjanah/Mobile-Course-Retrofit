package com.anisanurjanah.fahrameducationcourse.core.di

import androidx.room.Room
import com.anisanurjanah.fahrameducationcourse.core.data.source.local.room.CourseDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    factory { get<CourseDatabase>().courseDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            CourseDatabase::class.java, "Course.db"
        ).fallbackToDestructiveMigration().build()
    }
}