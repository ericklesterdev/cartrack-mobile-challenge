package com.mvvm.sample.di.modules.onboarding

import com.mvvm.sample.di.scopes.PerActivity
import com.mvvm.sample.presentation.onboarding.OnBoardingActivity
import com.mvvm.sample.presentation.onboarding.OnBoardingNavigation
import dagger.Binds
import dagger.Module

@Module
abstract class OnBoardingModule {

    @Binds
    @PerActivity
    abstract fun bindOnBoardingNavigation(nBoardingNavigation: OnBoardingActivity): OnBoardingNavigation
}
