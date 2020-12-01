package com.mvvm.sample.di

import com.mvvm.sample.di.modules.onboarding.DaggerOnBoardingComponent
import com.mvvm.sample.di.modules.onboarding.OnBoardingComponent
import com.mvvm.sample.presentation.mainSubComponent
import com.mvvm.sample.presentation.onboarding.OnBoardingActivity
import com.mvvm.sample.presentation.onboarding.login.LoginFragment

object Injector {

    private var onBoardingComponent: OnBoardingComponent? = null

    fun inject(activity: OnBoardingActivity) {
        onBoardingComponent = DaggerOnBoardingComponent.builder()
            .mainSubComponent(activity.mainSubComponent())
            .onBoardingActivity(activity)
            .build()

        onBoardingComponent?.inject(activity)
    }

    fun inject(fragment: LoginFragment) {
        onBoardingComponent?.loginComponent()?.inject(fragment)
    }

}