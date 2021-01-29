package com.example.myapplication.core.di

import androidx.appcompat.app.AppCompatActivity
import toothpick.config.Module

class ActivityModule(activity: AppCompatActivity) : Module() {
    init {
        bind(AppCompatActivity::class.java).toInstance(activity)
    }
}
