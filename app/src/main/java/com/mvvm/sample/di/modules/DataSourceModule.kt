package com.mvvm.sample.di.modules

import com.mvvm.sample.data.source.store.CloudUserStore
import com.mvvm.sample.data.source.store.WsUserDataStore
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindCloudUserStore(store: WsUserDataStore): CloudUserStore
}