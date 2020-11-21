package com.mvvm.sample.di.modules

import com.mvvm.sample.data.repositories.UsersDataRepository
import com.mvvm.sample.domain.repositories.UsersRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoriesModule {

    @Singleton
    @Binds
    abstract fun bindUsersRepository(repository: UsersDataRepository): UsersRepository

}