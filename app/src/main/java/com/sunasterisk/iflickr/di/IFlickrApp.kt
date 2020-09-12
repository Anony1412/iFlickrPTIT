package com.sunasterisk.iflickr.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class IFlickrApp: Application() {

    override fun onCreate() {
        super.onCreate()
        
        startKoin {
            androidLogger()
            androidContext(this@IFlickrApp)
            modules(listOf(apiModule, sourceModule, viewModelModule))
        }
    }
}
