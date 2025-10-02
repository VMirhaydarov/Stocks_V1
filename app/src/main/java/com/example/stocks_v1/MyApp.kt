package com.example.stocks_v1

import android.app.Application
import com.example.stocks_v1.di.AppComponent
import com.example.stocks_v1.di.DaggerAppComponent

class MyApp : Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

