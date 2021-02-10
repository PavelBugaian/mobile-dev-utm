package com.example.myapplication.core.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.SupervisorJob

abstract class BaseViewModel : ViewModel() {
    private val viewModelJob = SupervisorJob()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
