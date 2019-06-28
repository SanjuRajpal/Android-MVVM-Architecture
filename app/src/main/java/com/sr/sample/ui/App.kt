package com.sr.sample.ui

import android.app.Application
import com.sr.sample.retrofit.Retrofit

class App : Application() {

    companion object Singleton {
        private lateinit var app: App
        fun getInstance(): App {
            return app
        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        Retrofit.init()
    }

}