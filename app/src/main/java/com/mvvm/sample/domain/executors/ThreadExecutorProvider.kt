package com.mvvm.sample.domain.executors

import com.mvvm.sample.domain.executors.ThreadExecutor
import io.reactivex.Scheduler

interface ThreadExecutorProvider {

    fun jobExecutor(): ThreadExecutor

    fun ioScheduler(): Scheduler

    fun computationScheduler(): Scheduler

    fun trampoline(): Scheduler
}
