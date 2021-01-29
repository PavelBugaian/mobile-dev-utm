package com.example.myapplication.core

import android.os.Bundle
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.example.myapplication.R

abstract class NavigationActivity : BaseActivity(),
    NavigationListener {
    protected val navigationController by lazy { findNavController(R.id.nav_host_fragment) }

    override fun navigate(resId: Int, navOptions: NavOptions) {
        navigationController.navigate(resId, null, navOptions)
    }

    override fun navigate(resId: Int, bundle: Bundle) {
        navigationController.navigate(resId, bundle)

    }

    override fun navigate(resId: Int) {
        navigationController.navigate(resId)
    }

    override fun popBackStack() {
        navigationController.popBackStack()
    }
}
