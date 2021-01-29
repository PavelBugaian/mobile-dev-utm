package com.example.myapplication.core

import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.core.viewmodel.BaseViewModel
import com.example.myapplication.core.viewmodel.ViewModelFactory
import toothpick.Toothpick
import kotlin.reflect.KClass

@MainThread
fun <VM : BaseViewModel> Fragment.activityViewModels(
    klass: KClass<VM>,
    factoryProducer: (() -> ViewModelProvider.Factory)? = null
) = createViewModelLazy(
    klass,
    { requireActivity().viewModelStore },
    factoryProducer ?: { Toothpick.openScope(activity!!.application).getInstance(ViewModelFactory::class.java) }
)
