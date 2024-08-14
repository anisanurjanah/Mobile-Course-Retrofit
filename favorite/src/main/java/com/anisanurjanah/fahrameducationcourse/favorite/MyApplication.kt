package com.anisanurjanah.fahrameducationcourse.favorite

import android.app.Application
import com.anisanurjanah.fahrameducationcourse.core.di.databaseModule
import com.anisanurjanah.fahrameducationcourse.core.di.networkModule
import com.anisanurjanah.fahrameducationcourse.core.di.repositoryModule
import com.anisanurjanah.fahrameducationcourse.favorite.di.useCaseModule
import com.anisanurjanah.fahrameducationcourse.favorite.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}
