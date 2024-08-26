package com.anisanurjanah.fahrameducationcourse.core.di

import androidx.room.Room
import com.anisanurjanah.fahrameducationcourse.core.BuildConfig
import com.anisanurjanah.fahrameducationcourse.core.data.source.CourseRepository
import com.anisanurjanah.fahrameducationcourse.core.data.source.local.LocalDataSource
import com.anisanurjanah.fahrameducationcourse.core.data.source.local.room.CourseDatabase
import com.anisanurjanah.fahrameducationcourse.core.data.source.remote.RemoteDataSource
import com.anisanurjanah.fahrameducationcourse.core.data.source.remote.network.ApiService
import com.anisanurjanah.fahrameducationcourse.core.domain.repository.ICourseRepository
import com.anisanurjanah.fahrameducationcourse.core.utils.AppExecutors
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
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
        val passphrase: ByteArray = SQLiteDatabase.getBytes("neilr27".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            CourseDatabase::class.java, "Course.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        val hostname = "fahram.dev"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/+uMZCNRTm1erwPmPlRf0o+oIqPGmm4PqDg8S7S0kPjg=")
            .add(hostname, "sha256/kIdp6NNEd8wsugYyyIYFsi1ylMCED3hZbSR8ZFsa/A4=")
            .add(hostname, "sha256/mEflZT5enoR1FuXLgYYGqnVEoZvmf9c2bVBpiOjYQ0c=")
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
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

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<ICourseRepository> {
        CourseRepository(
            get(),
            get(),
            get()
        )
    }
}