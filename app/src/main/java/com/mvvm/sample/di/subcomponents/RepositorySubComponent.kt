package com.mvvm.sample.di.subcomponents

import com.mvvm.sample.domain.repositories.UsersRepository
import dagger.Subcomponent

@Subcomponent
interface RepositorySubComponent {

    fun provideUsersRepository(): UsersRepository

}