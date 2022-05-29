package com.leon.homework.ui

import com.leon.homework.R

data class LoginResult(
    val emailErrorId: Int = R.string.no_error,
    val passwordErrorId: Int = R.string.no_error,
    val isLoginSuccess: Boolean = false,
    val errorId: Int = R.string.login_failed
)
