package com.mvvm.sample.domain.executors

import com.mvvm.sample.domain.executors.PostExecutionThread
import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * MainThread (UI Thread) implementation based on a [ which will execute actions on the Android UI thread][io.reactivex.Scheduler]
 */
@Singleton
class UIThread @Inject
constructor() : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}