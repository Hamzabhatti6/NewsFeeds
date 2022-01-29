package com.hamza.bhatti.app

import android.app.Application

class ApplicationClass: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        @get:Synchronized
        var instance: ApplicationClass? = null
            private set
    }
}