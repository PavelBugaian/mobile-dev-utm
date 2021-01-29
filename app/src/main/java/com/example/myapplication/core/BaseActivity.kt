package com.example.myapplication.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Main
import com.example.myapplication.core.di.Dependencies
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {
    @Inject
    lateinit var application: Main

    abstract fun beforeLayoutInitialized()

    abstract fun getLayoutResId(): Int?

    abstract fun afterLayoutInitialized()

    final override fun onCreate(savedInstanceState: Bundle?) {
        Dependencies.inject(this)

        super.onCreate(savedInstanceState)

        beforeLayoutInitialized()

        val layout = getLayoutResId()
        if (layout != null) {
            setContentView(layout)
            afterLayoutInitialized()
        }
    }

    override fun onDestroy() {
        Dependencies.release(this)
        super.onDestroy()
    }
}
