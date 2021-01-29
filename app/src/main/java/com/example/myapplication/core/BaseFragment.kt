package com.example.myapplication.core

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.myapplication.core.di.Dependencies
import com.example.myapplication.core.viewmodel.BaseViewModel

abstract class BaseFragment<ViewModelClass : BaseViewModel, ViewBindingClass : ViewDataBinding>(
    viewModelClass: Class<ViewModelClass>
) :
    Fragment() {
    protected lateinit var viewBinding: ViewBindingClass
    protected val viewModel: ViewModelClass by activityViewModels(viewModelClass.kotlin)
    protected lateinit var navigationListener: NavigationListener

    abstract fun getLayoutResId(): Int

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Dependencies.inject(this)
        navigationListener = context as NavigationListener
    }

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
        viewBinding.lifecycleOwner = this
        viewBinding.setVariable(1, this)

        return viewBinding.root
    }

    override fun onDetach() {
        Dependencies.release(this)
        super.onDetach()
    }
}
