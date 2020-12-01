package com.mvvm.sample.presentation.onboarding

import android.os.Bundle
import com.mvvm.sample.R
import com.mvvm.sample.di.Injector.inject
import com.mvvm.sample.presentation.BaseActivity
import com.mvvm.sample.presentation.onboarding.login.LoginFragment
import kotlinx.android.synthetic.main.activity_main.*

class OnBoardingActivity : BaseActivity(), OnBoardingNavigation {

    override fun getLayoutResource(): Int = R.layout.activity_main

    override fun setupInjection() {
        inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCustomToolbar(toolbar_onboarding, false)

        showFragment(R.id.id_fragment_container, LoginFragment.newInstance(), false)
    }

    override fun onActivityFinishing() {

    }

    override fun redirectToMainScreen() {
        finish()
    }
}