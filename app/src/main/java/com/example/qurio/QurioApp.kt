package com.example.qurio

import android.app.Application
import com.example.qurio.di.AppComponent
import com.example.qurio.di.DaggerAppComponent

class QurioApp: Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory()
            .create(application = this)

        appComponent.inject(this)
    }
}