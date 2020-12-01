package com.mvvm.sample.di.modules.login

import com.mvvm.sample.di.scopes.PerFragment
import com.mvvm.sample.presentation.onboarding.login.LoginFragment
import dagger.Subcomponent

@Subcomponent(modules = [LoginModule::class])
@PerFragment
interface LoginComponent {

    fun inject(fragment: LoginFragment)
}