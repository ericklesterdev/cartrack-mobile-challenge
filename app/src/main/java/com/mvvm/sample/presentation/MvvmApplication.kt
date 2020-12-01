package com.mvvm.sample.presentation

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.FragmentActivity
import com.mvvm.sample.di.components.CoreComponent
import com.mvvm.sample.di.components.DaggerCoreComponent
import io.reactivex.plugins.RxJavaPlugins

class MvvmApplication : Application() {

    companion object {
        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as MvvmApplication).coreComponent
    }

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.builder()
            .application(this)
            .context(this)
            .build()
    }

    override fun onCreate() {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        super.onCreate()

        /**
         * Suppress extra exceptions that may happen after disposing/unSubscribing Observable/Flowable.
         * onError(), can't catch the extra errors after the source has been cancelled/disposed.
         */
        RxJavaPlugins.setErrorHandler { throwable ->
            throwable.printStackTrace()
        }
    }
}

fun Activity.mainSubComponent() = MvvmApplication.coreComponent(
    this
).mainSubComponentBuilder().build()

fun FragmentActivity.mainSubComponent() = MvvmApplication.coreComponent(
    this
).mainSubComponentBuilder().build()