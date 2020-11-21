package com.mvvm.sample.di.subcomponents

import com.mvvm.sample.data.source.store.CloudUserStore
import dagger.Subcomponent

@Subcomponent
interface DataStoreSubComponent {
    fun provideCloudUserStore(): CloudUserStore
}