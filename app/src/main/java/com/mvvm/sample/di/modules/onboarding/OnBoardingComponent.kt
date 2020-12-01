package com.mvvm.sample.di.modules.onboarding

import com.mvvm.sample.di.components.BaseComponent
import com.mvvm.sample.di.subcomponents.MainSubComponent
import com.mvvm.sample.di.modules.login.LoginComponent
import com.mvvm.sample.di.scopes.PerActivity
import com.mvvm.sample.presentation.onboarding.OnBoardingActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [OnBoardingModule::class],
    dependencies = [MainSubComponent::class]
)
@PerActivity
interface OnBoardingComponent : BaseComponent<OnBoardingActivity> {

    fun loginComponent(): LoginComponent


    @Component.Builder
    interface Builder {
        fun mainSubComponent(module: MainSubComponent): Builder

        @BindsInstance
        fun onBoardingActivity(activity: OnBoardingActivity): Builder

        fun build(): OnBoardingComponent
    }
}