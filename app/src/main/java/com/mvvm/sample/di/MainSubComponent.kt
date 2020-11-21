package com.mvvm.sample.di

import android.app.Application
import com.mvvm.sample.di.subcomponents.DataStoreSubComponent
import com.mvvm.sample.di.subcomponents.RepositorySubComponent
import com.mvvm.sample.di.subcomponents.ThreadProviderSubComponent
import dagger.Subcomponent

@Subcomponent
interface MainSubComponent :
    RepositorySubComponent,
    DataStoreSubComponent,
    ThreadProviderSubComponent {

    fun provideApplication(): Application

    @Subcomponent.Builder
    interface Builder {
        fun build(): MainSubComponent
    }
}