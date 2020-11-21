package com.mvvm.sample.di

import android.app.Application
import android.content.Context
import com.mvvm.sample.di.modules.ThreadProviderModule
import com.mvvm.sample.di.modules.DataSourceModule
import com.mvvm.sample.di.modules.NetworkModule
import com.mvvm.sample.di.modules.RepositoriesModule
import com.mvvm.sample.di.modules.StorageModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        NetworkModule::class,
        DataSourceModule::class,
        RepositoriesModule::class,
        StorageModule::class,
        ThreadProviderModule::class
    ]
)
@Singleton
interface CoreComponent {

    fun mainSubComponentBuilder(): MainSubComponent.Builder

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): CoreComponent
    }
}