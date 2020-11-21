package com.mvvm.sample.domain.executors

import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

@Singleton
class SchedulerProvider @Inject constructor(private val threadExecutor: ThreadExecutor) :
    ThreadExecutorProvider {

    override fun jobExecutor(): ThreadExecutor {
        return threadExecutor
    }

    override fun ioScheduler(): Scheduler {
        return Schedulers.io()
    }

    override fun computationScheduler(): Scheduler {
        return Schedulers.computation()
    }

    override fun trampoline(): Scheduler {
        return Schedulers.trampoline()
    }
}
