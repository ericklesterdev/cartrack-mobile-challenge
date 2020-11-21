package com.mvvm.sample.di.modules

import android.content.Context
import com.mvvm.sample.data.source.local.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Provides
    @Singleton
    fun bindAppDatabase(context: Context): AppDatabase =
        AppDatabase.getInstance(context)
}