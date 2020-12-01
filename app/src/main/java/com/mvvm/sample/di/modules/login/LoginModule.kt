package com.mvvm.sample.di.modules.login


import com.mvvm.sample.di.scopes.PerFragment
import com.mvvm.sample.domain.usecase.validator.AccountCredentialValidator
import com.mvvm.sample.domain.usecase.validator.AccountCredentialValidatorUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class LoginModule {

    @Binds
    @PerFragment
    abstract fun bindAccountCredentialValidatorUseCase(useCase: AccountCredentialValidator): AccountCredentialValidatorUseCase
}