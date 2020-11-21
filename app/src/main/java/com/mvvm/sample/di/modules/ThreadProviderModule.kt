package com.mvvm.sample.di.modules

import com.mvvm.sample.domain.executors.*
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ThreadProviderModule {

    @Binds
    @Singleton
    abstract fun bindThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor

    @Binds
    @Singleton
    abstract fun bindThreadExecutorProvider(schedulerProvider: SchedulerProvider): ThreadExecutorProvider

    @Binds
    @Singleton
    abstract fun bindPostExecutionThread(uiThread: UIThread): PostExecutionThread
}