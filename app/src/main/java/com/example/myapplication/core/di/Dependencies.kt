package com.example.myapplication.core.di

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.Main
import toothpick.Toothpick

class Dependencies {

    companion object {

        /**
         * Injects dependencies into application scope.
         *
         *
         * Call this in [Application.onCreate].
         *
         * @param application application to be injected with dependencies.
         */
        fun inject(application: Main) {
            val scope = Toothpick.openScope(application)
            scope.installModules(AppModule(application))
            Toothpick.inject(application, scope)
        }

        /**
         * Injects dependencies into activity scope.
         * <p>
         * Call this in {@link Activity#onCreate} before the call to super.
         * If you call this after, fragment attachment will crash the app, because
         * they are attached in the call to super, and dependencies are not ready yet.
         * <p>
         * Call {@link #release(Activity)} inside {@link Activity#onDestroy}
         *
         * @param activity activity to be injected with dependencies
         * @see #release(Activity)
         */
        fun inject(activity: AppCompatActivity) {
            val scope = Toothpick.openScopes(activity.application, activity)
            scope.installModules(ActivityModule(activity))
            Toothpick.inject(activity, scope)
        }

        /**
         * Releases scoped dependencies to make them eligible for garbage collection.
         * <p>
         * Call this in {@link Activity#onDestroy}
         *
         * @param activity activity that had dependencies injected
         * @see #inject(Activity)
         */
        fun release(activity: AppCompatActivity) {
            Toothpick.closeScope(activity)
        }

        /**
         * Injects dependencies into fragment scope.
         * <p>
         * Call this in {@link Fragment#onAttach}.
         * <p>
         * Call {@link #release(Fragment)} inside {@link Fragment#onDetach()}.
         *
         * @param fragment fragment to be injected with dependencies
         * @see #release(Fragment)
         */
        fun inject(fragment: Fragment) {
            val scope = Toothpick.openScopes(
                fragment.activity?.application,
                fragment.activity,
                fragment
            )
            scope.installModules(FragmentModule(fragment))
            Toothpick.inject(fragment, scope)
        }

        /**
         * Releases scope dependencies to make them eligible for garbage collection.
         * <p>
         * Call this in {@link Fragment#onDetach()}
         *
         * @param fragment fragment that had dependencies injected
         * @see #inject(Fragment)
         */
        fun release(fragment: Fragment) {
            Toothpick.closeScope(fragment)
        }
    }
}
