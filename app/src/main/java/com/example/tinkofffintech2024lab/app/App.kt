package com.example.tinkofffintech2024lab.app

import android.app.Application
import com.example.tinkofffintech2024lab.di.appModule
import com.example.tinkofffintech2024lab.di.dataModule
import com.example.tinkofffintech2024lab.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR) // Log Koin into Android logger
            androidContext(androidContext = this@App) // add application context. It will be used for creating SharedPrefsUserStorage
            modules(listOf(
                appModule,
                domainModule,
                dataModule
            ))
        }

    }

}