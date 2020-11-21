package com.mvvm.sample.di.subcomponents

import com.mvvm.sample.domain.executors.PostExecutionThread
import com.mvvm.sample.domain.executors.ThreadExecutorProvider
import dagger.Subcomponent

@Subcomponent
interface ThreadProviderSubComponent {
    fun providePostExecutionThread(): PostExecutionThread

    fun provideThreadExecutorProvider(): ThreadExecutorProvider
}