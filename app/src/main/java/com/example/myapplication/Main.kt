package com.example.myapplication

import android.app.Application
import com.example.myapplication.core.di.Dependencies

class Main : Application() {

    override fun onCreate() {
        super.onCreate()

        Dependencies.inject(this)
    }
}
