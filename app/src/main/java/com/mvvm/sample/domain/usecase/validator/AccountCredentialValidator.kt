package com.mvvm.sample.domain.usecase.validator

import java.util.regex.Pattern
import javax.inject.Inject

class AccountCredentialValidator @Inject constructor() : AccountCredentialValidatorUseCase {

    companion object {
        private val EMAIL_ADDRESS_PATTERN = Pattern
            .compile(
                "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@"
                        + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\."
                        + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+"
            )
    }

    override fun isEmailValid(email: String): Boolean {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
    }

    /**
     * Simple validation that checks if password's length is > 3
     */
    override fun isPasswordValid(password: String): Boolean {
       return password.length > 3
    }
}