package com.leon.homework.ui

import com.leon.homework.R

data class LoginResult(
    val isLoginSuccess: Boolean = false,
    val errorId: Int = R.string.login_failed
)
