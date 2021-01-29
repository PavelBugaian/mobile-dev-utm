package com.example.myapplication.core.di

import com.example.myapplication.MainViewModel
import com.example.myapplication.Main
import com.example.myapplication.core.viewmodel.ViewModelFactory
import toothpick.config.Module

class AppModule(application: Main) : Module() {
    init {
        bind(Main::class.java).toInstance(application)

        bind(ViewModelFactory::class.java).singletonInScope()

        bind(MainViewModel::class.java)
    }
}
