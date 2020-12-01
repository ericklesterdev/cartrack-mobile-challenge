package com.mvvm.sample.presentation.onboarding.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mvvm.sample.R
import com.mvvm.sample.domain.usecase.validator.AccountCredentialValidatorUseCase
import com.mvvm.sample.presentation.onboarding.OnBoardingNavigation
import javax.inject.Inject


class LoginViewModel @Inject constructor(
    private val accountCredentialValidator: AccountCredentialValidatorUseCase,
    private val onBoardingNavigation: OnBoardingNavigation
) : ViewModel() {

    var email: String = ""
        set(value) {
            field = value
            if (accountCredentialValidator.isEmailValid(value))
                emailError.value = null
            else
                emailError.value = R.string.error_invalid_email
        }

    var password: String = ""
        set(value) {
            field = value
            if (accountCredentialValidator.isPasswordValid(value))
                passwordError.value = null
            else
                passwordError.value = R.string.error_invalid_password
        }

    val emailError = MutableLiveData<Int?>()
    val passwordError = MutableLiveData<Int?>()

    fun onLoginClick() {

        var allowLogin = true

        if (!accountCredentialValidator.isEmailValid(email)) {
            emailError.value = R.string.error_invalid_email
            allowLogin = false
        }

        if (!accountCredentialValidator.isPasswordValid(password)) {
            passwordError.value = R.string.error_invalid_password
            allowLogin = false
        }

        if (allowLogin) {
            // Usually calls to a backend service but for simplicity we will just launch the next Activity
            onBoardingNavigation.redirectToMainScreen()
        }
    }

}