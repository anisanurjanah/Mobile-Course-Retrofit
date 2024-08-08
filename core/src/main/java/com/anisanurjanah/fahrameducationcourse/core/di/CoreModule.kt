package com.anisanurjanah.fahrameducationcourse.core.di

import androidx.room.Room
import com.anisanurjanah.fahrameducationcourse.core.BuildConfig
import com.anisanurjanah.fahrameducationcourse.core.data.source.local.room.CourseDatabase
import com.anisanurjanah.fahrameducationcourse.core.data.source.remote.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<CourseDatabase>().courseDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            CourseDatabase::class.java, "Course.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}