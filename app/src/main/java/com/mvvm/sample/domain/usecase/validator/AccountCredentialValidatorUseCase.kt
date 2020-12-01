package com.mvvm.sample.domain.usecase.validator

interface AccountCredentialValidatorUseCase {

    fun isEmailValid(email: String): Boolean

    fun isPasswordValid(password: String): Boolean
}