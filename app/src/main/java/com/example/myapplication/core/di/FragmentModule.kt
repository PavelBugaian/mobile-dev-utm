package com.example.myapplication.core.di

import androidx.fragment.app.Fragment
import toothpick.config.Module

class FragmentModule(fragment: Fragment) : Module() {
    init {
        bind(Fragment::class.java).toInstance(fragment)
    }
}
