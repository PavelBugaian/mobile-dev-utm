package com.example.myapplication

import com.example.myapplication.core.NavigationActivity

class MainActivity : NavigationActivity() {
    override fun beforeLayoutInitialized() {}

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun afterLayoutInitialized() {}
}
